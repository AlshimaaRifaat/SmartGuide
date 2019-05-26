package com.example.alshimaa.smartguide.fragment;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.example.alshimaa.smartguide.R;
import com.example.alshimaa.smartguide.activity.NavigationActivity;
import com.example.alshimaa.smartguide.activity.NavigationDriverActivity;
import com.example.alshimaa.smartguide.model.LocationData;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewOnMapDriverFragment extends Fragment implements OnMapReadyCallback

        , RoutingListener, GoogleApiClient.OnConnectionFailedListener
        , GoogleApiClient.ConnectionCallbacks, LocationListener {

    GoogleMap mGoogleMap;
    MapView mapView;
    ImageView iconPlus;
    Toolbar toolbar;
    Context context;
    LocationRequest locationReques;
    Marker currentLocationMaker;

    private DatabaseReference mDatabase;
    int REQUEST_LOCATION_CODE = 99;
    Double BusLat, BusLng;
    String Status;
    private ProgressDialog progressDialog;
    private List<Polyline> polylines;
    private static final int[] COLORS = new int[]{R.color.colorBlue, R.color.colorBlue, R.color.colorBlue, R.color.colorBlue, R.color.colorBlue};
    protected LatLng start;
    protected LatLng end;
    Marker m;
    Integer BusSpeed;
    protected GoogleApiClient mGoogleApiClient;
   private Location lastLocation;
   private static final int Request_User_Location_Code=99;

    SupportMapFragment mapFragment;





    public ViewOnMapDriverFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_view_on_map_driver, container, false);
        context = this.getActivity();
        getActivity().getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        init();
        polylines = new ArrayList<>();


        NavigationDriverActivity.toggle_driver = new ActionBarDrawerToggle(
                getActivity(), NavigationDriverActivity.drawer_driver, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        NavigationDriverActivity.drawer_driver.addDrawerListener(NavigationDriverActivity.toggle_driver);
        NavigationDriverActivity.toggle_driver.syncState();

        NavigationDriverActivity.toggle_driver.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.group151);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationDriverActivity.drawer_driver.isDrawerOpen(GravityCompat.START)) {
                    NavigationDriverActivity.drawer_driver.closeDrawer(GravityCompat.START);
                } else {
                    NavigationDriverActivity.drawer_driver.openDrawer(GravityCompat.START);
                }
            }
        });


       // mapReady();
        startGettingLocations();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        getMarkers();
        return view;
    }

   /* private void mapReady() {
       *//* if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            buildApiClint();
            mGoogleMap.setMyLocationEnabled(true);
            return;
        }*//*

    }*/

    public void buildApiClint(){

            mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            mGoogleApiClient.connect();



    }

    private void startGettingLocations() {

            LocationManager lm = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

            boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
            boolean canGetLocation = true;
            int ALL_PERMISSIONS_RESULT = 101;
            long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;// Distance in meters
            long MIN_TIME_BW_UPDATES = 1000 * 10;// Time in milliseconds

            ArrayList<String> permissions = new ArrayList<>();
            ArrayList<String> permissionsToRequest;

            permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
            permissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
            permissionsToRequest = findUnAskedPermissions(permissions);

            //Check if GPS and Network are on, if not asks the user to turn on
            if (!isGPS && !isNetwork) {
                showSettingsAlert();
            } else {
                // check permissions

                // check permissions for later versions
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (permissionsToRequest.size() > 0) {
                        checkUserLocationPermission();
                  /*  requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                            ALL_PERMISSIONS_RESULT);
                    canGetLocation = false;*/
                    }
                }
            }

        //Checks if FINE LOCATION and COARSE Location were granted
        if (ActivityCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(getContext(), "Permissão negada", Toast.LENGTH_SHORT).show();
            return;
        }

        //Starts requesting location updates

    }

    private void showSettingsAlert() {


        Toast.makeText(context, "showSettingsAlert Dialog", Toast.LENGTH_SHORT).show();
    }

    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String perm) {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (context.checkSelfPermission(perm) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;

    }



    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    private void init() {

        toolbar=view.findViewById( R.id.view_on_map_driver_tool_bar );
         mapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.map_driver);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mapView=view.findViewById(R.id.map);
//        if (mapView!=null)
//        {
//            mapView.onCreate(null);
//            mapView.onResume();
//            mapView.getMapAsync(this);
//        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
      //  buildApiClint();
        mGoogleMap=googleMap;
        if (context!=null)
        {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            buildApiClint();
            mGoogleMap.setMyLocationEnabled(true);
            mGoogleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

                @Override
                public void onMyLocationChange(Location location) {
                    // TODO Auto-generated method stub
                    if (currentLocationMaker != null) {
                        currentLocationMaker.remove();
                    }
                    currentLocationMaker = mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).icon(BitmapDescriptorFactory.fromResource(R.drawable.bus)));

                /*Toast.makeText(context, String.valueOf(location.getLatitude())+" "+String.valueOf(location.getLongitude()), Toast.LENGTH_SHORT).show();
                    Toast.makeText(context,String.valueOf(DetailsHomeDriverFragment.CompanyId) , Toast.LENGTH_SHORT).show();
                    Toast.makeText(context,String.valueOf(DetailsHomeDriverFragment.TripId) , Toast.LENGTH_SHORT).show();*/
                    if (String.valueOf(location.getLatitude()) != null && String.valueOf(location.getLongitude()) != null) {
                        mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("lat").setValue(String.valueOf(location.getLatitude()));
                        mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("lng").setValue(String.valueOf(location.getLongitude()));
                    }
                    mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("speed").setValue(Integer.valueOf("0"));
                    // Toast.makeText(context, DetailsHomeDriverFragment.clicked, Toast.LENGTH_SHORT).show();
                /*if (DetailsHomeDriverFragment.clicked.equals("start_clicked")) {
                        mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("status").setValue("on");
                    }else if (DetailsHomeDriverFragment.clicked.equals("end_clicked")) {
                        mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("status").setValue("off");
                    }*/

                    mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).child("status").setValue("off");


                }
            });

        }

        }

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
       /* googleMap.addMarker(new MarkerOptions().position(new LatLng(-34,151)).title("statue of liberty").snippet("snippet"));
        CameraPosition Liberty=CameraPosition.builder().target(new LatLng(-34,151))
                .bearing(8).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(Liberty));*/
        // Toast.makeText(getContext(), DetailsFollowFlightsFragment.StartLat, Toast.LENGTH_SHORT).show();
        start = new LatLng(Double.parseDouble(DetailsHomeDriverFragment.StartLat), Double.parseDouble(DetailsHomeDriverFragment.StartLng));
        mGoogleMap.addMarker(new MarkerOptions().position(start).title("موضع بدء الرحله"));

        CameraPosition cameraPosition1 = new CameraPosition.Builder().target(start).build();
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition1));

        end = new LatLng(Double.parseDouble(DetailsHomeDriverFragment.EndLat), Double.parseDouble(DetailsHomeDriverFragment.EndLng));
        mGoogleMap.addMarker(new MarkerOptions().position(end).title("موضع انهاء الرحله"));

        CameraPosition cameraPosition2 = new CameraPosition.Builder().target(end).build();
        mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition2));




       // Toast.makeText(context, "cuuuur  "+String.valueOf(lastLocation.getLatitude())+" "+String.valueOf(lastLocation.getLongitude()), Toast.LENGTH_SHORT).show();






        getMarkers();

        /*LatLng a=new LatLng(30.132419, 31.321792);
        LatLng b=new LatLng(30.113533, 31.286533);*/




        Routing routing = new Routing.Builder()
                .travelMode(AbstractRouting.TravelMode.DRIVING)
                .withListener(this)
                .key("AIzaSyCaf2jejQzVtF7myO4R-P2mEFmGoiom1Pc")
                .alternativeRoutes(false)
                .waypoints(start, end)
                .build();
        routing.execute();


    }
public boolean checkUserLocationPermission()
{
    if (ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) !=PackageManager.PERMISSION_GRANTED)
    {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION))
        {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
        }else {
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},Request_User_Location_Code);
        }
         return false;
    }else
    {
        return true;
    }

}

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case Request_User_Location_Code:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    if (ActivityCompat.checkSelfPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) ==PackageManager.PERMISSION_GRANTED)
                    {
                        if (mGoogleApiClient==null)
                        {
                            buildApiClint();
                        }
                        mGoogleMap.setMyLocationEnabled(true);
                    }
                }else
                {
                    Toast.makeText(context, "permission denied", Toast.LENGTH_SHORT).show();
                }return;
        }
    }



    private void getMarkers(){


      /*  mDatabase.child("buses").child(DetailsHomeDriverFragment.CompanyId).child(DetailsHomeDriverFragment.TripId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(m!=null){
                    m.remove();
                }
                if (dataSnapshot.getValue() != null)
                {
                    BusLat=Double.parseDouble(dataSnapshot.child("lat").getValue().toString());
                    BusLng=Double.parseDouble(dataSnapshot.child("lng").getValue().toString());
                    BusSpeed=Integer.parseInt(dataSnapshot.child("speed").getValue().toString());

                    //getAllLocations((Map<String,Object>) dataSnapshot.getValue());
                    LatLng BusLatLng=new LatLng(BusLat,BusLng);

//                            MarkerOptions option_bus = new MarkerOptions();
//                            option_bus.position(BusLatLng);
//                            option_bus.title("bus");
//                            option_bus.icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_icon));
//                            mGoogleMap.addMarker(option_bus);

                    m=mGoogleMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bus_icon))
                            .title(DetailsHomeDriverFragment.BusNumber).snippet(" سرعة "+String.valueOf(BusSpeed)+"KM ").position(BusLatLng));
                    // Toast.makeText(context, String.valueOf(BusSpeed), Toast.LENGTH_SHORT).show();

                    if(context!=null) {
                        //Toast.makeText(context, String.valueOf(BusLat) + " " + String.valueOf(BusLng), Toast.LENGTH_SHORT).show();
                    }
                    // mGoogleMap.addMarker(new MarkerOptions().position(Bus).title("bus"));
                    // Toast.makeText(getContext(), String.valueOf(CurrentLat)+" "+String.valueOf(CurrentLng), Toast.LENGTH_SHORT).show();
                   *//* Map<String,String> map=dataSnapshot.getValue(Map.class);
                    String Lat=map.get("lat");
                    String Lng=map.get("lng");
                    String Speed=map.get("speed");
                    Toast.makeText(getContext(), "lat "+Lat+"lng "+Lng+"speed "+Speed, Toast.LENGTH_SHORT).show();*//*
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }

  /*  private void getAllLocations(Map<String, Object> locations) {
        for (Map.Entry<String, Object> entry : locations.entrySet()){
//            Date newDate = new Date(Long.valueOf(entry.getKey()));
            Map singleLocation = (Map) entry.getValue();
            LatLng latLng = new LatLng((Double) singleLocation.get("lat"), (Double)singleLocation.get("lng"));
            addGreenMarker( latLng);
        }
    }
    private void addGreenMarker( LatLng latLng) {
       // SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
       // markerOptions.title(dt.format(newDate));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mGoogleMap.addMarker(markerOptions);
    }*/



   /* private void getAllLocations(Map<String,Object> locations) {
       for (Map.Entry<String, Object> entry : locations.entrySet()) {
            //Date newDate = new Date(Long.valueOf(entry.getKey()));
            Map singleLocation = (Map) entry.getValue();
            LatLng latLng = new LatLng((Double) singleLocation.get("lat"), (Double) singleLocation.get("lng"));
            addGreenMarker( latLng);
        }
    }*/
    /*private void addGreenMarker( LatLng latLng) {
       // SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
       // markerOptions.title(dt.format(newDate));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mGoogleMap.addMarker(markerOptions);
    }*/

    @Override
    public void onRoutingFailure(RouteException e) {
        if (context!=null) {
            if (e != null) {
                Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Something went wrong, Try again", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {
        CameraUpdate center = CameraUpdateFactory.newLatLng(start);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(3);
        mGoogleMap.animateCamera(zoom);
        mGoogleMap.moveCamera(center);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(start);
        builder.include(end);
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 14));



        if(polylines.size()>0) {
            for (Polyline poly : polylines) {
                poly.remove();
            }
        }

        polylines = new ArrayList<>();
        //add route(s) to the map.
        for (int i = 0; i <route.size(); i++) {

            //In case of more than 5 alternative routes
            int colorIndex = i % COLORS.length;

            PolylineOptions polyOptions = new PolylineOptions();
            if (context != null) {
                polyOptions.color(context.getResources().getColor(COLORS[colorIndex]));

            }
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(route.get(i).getPoints());
            Polyline polyline = mGoogleMap.addPolyline(polyOptions);
            polylines.add(polyline);


            // Toast.makeText(getContext(),"Route "+ (i+1) +": distance - "+ route.get(i).getDistanceValue()+": duration - "+ route.get(i).getDurationValue(),Toast.LENGTH_SHORT).show();
        }

        // Start marker
        MarkerOptions options = new MarkerOptions();
        options.position(start);
        // options.icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
        mGoogleMap.addMarker(options);

        // End marker
        options = new MarkerOptions();
        options.position(end);
        //options.icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
        mGoogleMap.addMarker(options);


    }

    @Override
    public void onRoutingCancelled() {
        Toast.makeText(getContext(), "Routing was cancelled.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationReques=new LocationRequest();
        locationReques.setInterval(1100);
        locationReques.setFastestInterval(1100);
        locationReques.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED  )
        {
            return;
        }
//       LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,locationReques, (com.google.android.gms.location.LocationListener) this);




    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getContext(), connectionResult.toString(), Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}