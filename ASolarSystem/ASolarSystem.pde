import peasy.*;       // importing new library called PeasyCam to be able to navigate camera in the sketch
import ddf.minim.*;   //importing new library to be able to play music

Minim minim;          // enabling the library
AudioPlayer player;   // enabling the library function 
PeasyCam cam;         // enabling the library

AstronomicalObject Solis; 

PImage sunTexture;  // Image for Sun
PImage[] texture = new PImage[7]; //Array of images for planets
PImage galaxy; // image for background

void setup() {
  minim = new Minim(this);
  player = minim.loadFile("SpaceMusic.mp3"); //finding and declaring mp3 
  player.play(); // switching on the music
  size(1000, 800, P3D);
  
  cam = new PeasyCam(this,700); // enabling camera and defining its position
  
  sunTexture = loadImage("sun.jpg"); //finding and declaring jpg
  texture[0] = loadImage("neptune.jpg");
  texture[1] = loadImage("earth.jpg");
  texture[2] = loadImage("mars.jpg");
  texture[3] = loadImage("jupiter.jpg");
  texture[4] = loadImage("saturn.jpg");
  texture[5] = loadImage("uranus.jpg");
  texture[6] = loadImage("mercury.jpg");
  galaxy = loadImage("galaxy.jpg");

  Solis = new AstronomicalObject(50, 0, 0, sunTexture);
  Solis.CreatingSatellites(9);
}

void draw() 
{
  background(galaxy);
  
  Solis.show();
  Solis.orbit();
}
