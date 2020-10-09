class AstronomicalObject {
  float radius;
  float angle;
  float distance;
  float orbitspeed;
  AstronomicalObject[] AstronomicalObjects;
  PVector v;
  PShape globe;
  AstronomicalObject(float r, float d, float os, PImage img) {
    v = PVector.random3D(); //creating a random 3D dimension
    radius = r; // initializing
    distance = d; 
    v.mult(distance); // initil/creating a distance/path by applying a scalar for line 44                "x2+y*6"
    orbitspeed = os; //defining os 
    angle = random(1, 360); // creating a random angle from 1 to 360
    noStroke();
    noFill();    
    globe = createShape(SPHERE, radius);
    globe.setTexture(img); //assigning an image for sun
  }
  void orbit() { //enabling the void show at "" Solar System line 41
    angle = angle + orbitspeed; //producing angle rotation by adding orbitspeed
    if (AstronomicalObjects !=null) { // each AstronomicalObjects create an Array of AstronomicalObjects therefore whenever it has not created another list it will carry on working
      for (int i = 0; i < AstronomicalObjects.length; i = i + 1) { //creating selected amount of orbits for each planet/AstronomicalObjects
        AstronomicalObjects[i].orbit();   //assigning the orbit to each planet
      }
    }
  }
  void CreatingSatellites(int total) { // creatinf a specific amount of pla "" SolarSystem line 33  
    AstronomicalObjects = new AstronomicalObject[total]; // producing new array list for AstronomicalObject for each AstronomicalObject  "" SolarSystem line 32  
    for (int i = 0; i < AstronomicalObjects.length; i = i + 1) {  
      float r = random(radius/4, radius/1.3); //random sizes of the planets around the sun depending                    
      float d = random((radius+r)*2, (radius+r*3)*2); //Random Distanse that it is located from the SUN                                         on the radius "" SolarSystem 32                           
      float os = random(-0.015, 0.015); // OS stands for Orbit Speed therefore it can go to eachside randomly (left to right or right to left)   
      int planet = int(random(0, texture.length)); // producing a random value from 0 to 6 (the maxuimum length of texture array)
      AstronomicalObjects[i] = new AstronomicalObject(r, d, os, texture[planet]); //allocating random textures to planets from the array of textures
    }
  }
  void show() { //enabling the void show at "" Solar System line 40
    pushMatrix(); //applying push matrix
    PVector v2 = new PVector(1, 0, 1); //Producing a value for 3D from 1 to 10 
    PVector p = v.cross(v2); // producing an opposite value from PVector v2
    rotate(angle, p.x, p.y, p.z); // P and the direction of the axis is incharge of rotation of the orbit into different direction X,Y.Z 
    translate (v.x, v.y, v.z); //P is incharge of creation a translate position in a random 3D dimension "" LINE 13
    shape(globe);    //refering to the global declaration to make this shape into a globe to be able to cover it with a texture of a planet or a sun "" Line 18
    if (distance==0)
      pointLight(255, 255, 255, 0, 0, 0);      // Light from the center of the sun Distance = 0
    if (AstronomicalObjects !=null) {   // line 23
      for (int i = 0; i < AstronomicalObjects.length; i = i + 1) {  //line 24    
        AstronomicalObjects[i].show();                                // Displaying the amount of Astronomical object with different textures "Line 35,36
      }
    }
    popMatrix(); //retrieving  push matrix
  }
}
