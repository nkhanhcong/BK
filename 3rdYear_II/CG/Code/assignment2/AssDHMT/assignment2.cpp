

#include "stdafx.h"

#include <iostream>
#include <stdlib.h>
#include <glut.h>
#include <math.h>


using namespace std;
//supportClass.h
class Vector3
{
public:
	float	x, y, z;
	void set(float dx, float dy, float dz)
	{
		x = dx; y = dy; z = dz;
	}
	void set(Vector3& v)
	{
		x = v.x; y = v.y; z = v.z;
	}
	void flip()
	{
		x = -x; y = -y; z = -z;
	}
	void normalize();
	Vector3() { x = y = z = 0; }
	Vector3(float dx, float dy, float dz)
	{
		x = dx; y = dy; z = dz;
	}
	Vector3(Vector3& v)
	{
		x = v.x; y = v.y; z = v.z;
	}
	Vector3 cross(Vector3 b);
	float dot(Vector3 b);
};
class Point3
{
public:
	float x, y, z;
	Vector3 vertexNorm;

	void set(float dx, float dy, float dz)
	{
		x = dx; y = dy; z = dz;
	}
	void set(Point3& p)
	{
		x = p.x; y = p.y; z = p.z;
	}
	Point3() { x = y = z = 0; }
	Point3(float dx, float dy, float dz)
	{
		x = dx; y = dy; z = dz;
	}

};

Vector3 Vector3::cross(Vector3 b)
{
	Vector3 c(y*b.z - z*b.y, z*b.x - x*b.z, x*b.y - y*b.x);
	return c;
}
float Vector3::dot(Vector3 b)// tich vo huong vector
{
	return x*b.x + y*b.y + z*b.z;
}
void Vector3::normalize()
{
	float temp = sqrt(x*x + y*y + z*z);
	x = x / temp;
	y = y / temp;
	z = z / temp;
}

//Tga

typedef	struct
{
	GLubyte	* imageData;									// Image Data (Up To 32 Bits)
	GLuint	bpp;											// Image Color Depth In Bits Per Pixel
	GLuint	width;											// Image Width
	GLuint	height;											// Image Height
	GLuint	texID;											// Texture ID Used To Select A Texture
	GLuint	type;											// Image Type (GL_RGB, GL_RGBA)
} Texture;

typedef struct
{
	GLubyte Header[12];									// TGA File Header
} TGAHeader;


typedef struct
{
	GLubyte		header[6];								// First 6 Useful Bytes From The Header
	GLuint		bytesPerPixel;							// Holds Number Of Bytes Per Pixel Used In The TGA File
	GLuint		imageSize;								// Used To Store The Image Size When Setting Aside Ram
	GLuint		temp;									// Temporary Variable
	GLuint		type;
	GLuint		Height;									//Height of Image
	GLuint		Width;									//Width ofImage
	GLuint		Bpp;									// Bits Per Pixel
} TGA;


TGAHeader tgaheader;									// TGA header
TGA tga;										// TGA image data



GLubyte uTGAcompare[12] = { 0,0,2, 0,0,0,0,0,0,0,0,0 };	// Uncompressed TGA Header


bool LoadTGA(Texture * texture, char * filename)				// Load a TGA file
{
	FILE * fTGA;												// File pointer to texture file
	fTGA = fopen(filename, "rb");								// Open file for reading

	if (fTGA == NULL)											// If it didn't open....
	{
		return false;														// Exit function
	}

	if (fread(&tgaheader, sizeof(TGAHeader), 1, fTGA) == 0)					// Attempt to read 12 byte header from file
	{
		if (fTGA != NULL)													// Check to seeiffile is still open
		{
			fclose(fTGA);													// If it is, close it
		}
		return false;														// Exit function
	}

	// an Uncompressed TGA image
	if (fread(tga.header, sizeof(tga.header), 1, fTGA) == 0)					// Read TGA header
	{
		if (fTGA != NULL)													// if file is still open
		{
			fclose(fTGA);													// Close it
		}
		return false;														// Return failular
	}

	texture->width = tga.header[1] * 256 + tga.header[0];					// Determine The TGA Width	(highbyte*256+lowbyte)
	texture->height = tga.header[3] * 256 + tga.header[2];					// Determine The TGA Height	(highbyte*256+lowbyte)
	texture->bpp = tga.header[4];										// Determine the bits per pixel
	tga.Width = texture->width;										// Copy width into local structure						
	tga.Height = texture->height;										// Copy height into local structure
	tga.Bpp = texture->bpp;											// Copy BPP into local structure

	if ((texture->width <= 0) || (texture->height <= 0) || ((texture->bpp != 24) && (texture->bpp != 32)))	// Make sure all information is valid
	{
		if (fTGA != NULL)													// Check if file is still open
		{
			fclose(fTGA);													// If so, close it
		}
		return false;														// Return failed
	}

	if (texture->bpp == 24)													// If the BPP of the image is 24...
		texture->type = GL_RGB;											// Set Image type to GL_RGB
	else																	// Else if its 32 BPP
		texture->type = GL_RGBA;											// Set image type to GL_RGBA

	tga.bytesPerPixel = (tga.Bpp / 8);									// Compute the number of BYTES per pixel
	tga.imageSize = (tga.bytesPerPixel * tga.Width * tga.Height);		// Compute the total amout ofmemory needed to store data
	texture->imageData = (GLubyte *)malloc(tga.imageSize);					// Allocate that much memory

	if (texture->imageData == NULL)											// If no space was allocated
	{
		fclose(fTGA);														// Close the file
		return false;														// Return failed
	}

	if (fread(texture->imageData, 1, tga.imageSize, fTGA) != tga.imageSize)	// Attempt to read image data
	{
		if (texture->imageData != NULL)										// If imagedata has data in it
		{
			free(texture->imageData);										// Delete data from memory
		}
		fclose(fTGA);														// Close file
		return false;														// Return failed
	}

	// switch R and B
	for (int i = 0; i < tga.imageSize; i += tga.bytesPerPixel)
	{
		GLubyte temp = texture->imageData[i];
		texture->imageData[i] = texture->imageData[i + 2];
		texture->imageData[i + 2] = temp;
	}


	fclose(fTGA);															// Close file
	return true;															// All went well, continue on
}


//mesh.h

class VertexID
{
public:
	int		vertIndex;
	int		colorIndex;
};

class Face
{
public:
	int		nVerts;
	VertexID*	vert;
	Vector3		facenorm;

	Face()
	{
		nVerts = 0;
		vert = NULL;
	}
	~Face()
	{
		if (vert != NULL)
		{
			delete[] vert;
			vert = NULL;
		}
		nVerts = 0;
	}
};

class Mesh {

public:
	float slideX, slideY, slideZ;
public:
	float rotateX, rotateY, rotateZ;
public:
	float scaleX, scaleY, scaleZ;
public:
	int numVerts;
	Point3 *pt;

	int numFaces;
	Face *face;
public:
	Mesh() {
		numVerts = 0;
		pt = NULL;
		numFaces = 0;
		face = NULL;
	}

	~Mesh() {
		if (pt != NULL) {
			delete[] pt;
		}
		if (face != NULL) {
			delete[] face;
		}
		numVerts = 0;
		numFaces = 0;
	}

	void DrawWireframe();

	void Draw();
	void CalculateFacesNorm();

	void CreateCylinder(int nSegment, float fHeight, float fRadius);


	void CreateTorus(int nSlice, int nStack, float A, float D);
	void CalculateVertexNorm();

};

//mesh.cpp

#define PI			3.1415926
#define	COLORNUM		14
#define DEG2RAD PI/180

float	ColorArr[COLORNUM][3] = { { 1.0, 0.0, 0.0 },{ 0.0, 1.0, 0.0 },{ 0.0,  0.0, 1.0 },
{ 1.0, 1.0,  0.0 },{ 1.0, 0.0, 1.0 },{ 0.0, 1.0, 1.0 },
{ 0.3, 0.3, 0.3 },{ 0.5, 0.5, 0.5 },{ 0.9,  0.9, 0.9 },
{ 1.0, 0.5,  0.5 },{ 0.5, 1.0, 0.5 },{ 0.5, 0.5, 1.0 },
{ 0.0, 0.0, 0.0 },{ 1.0, 1.0, 1.0 } };

void Mesh::CreateCylinder(int nSegment, float fHeight, float fRadius)
{
	numVerts = 2 * nSegment + 2;
	pt = new Point3[numVerts];
	float segment = 360.0 / nSegment;

	for (int i = 0; i < nSegment; i++) {
		pt[i].set(fRadius*cos(DEG2RAD*i*segment), 0, fRadius*sin(DEG2RAD*i*segment));
	}
	for (int i = nSegment; i < 2 * nSegment; i++) {
		pt[i].set(fRadius*cos(DEG2RAD*(i - nSegment)*segment), fHeight, fRadius*sin(DEG2RAD*(i - nSegment)*segment));
	}
	pt[2 * nSegment].set(0, 0, 0);
	pt[2 * nSegment + 1].set(0, fHeight, 0);


	numFaces = 3 * nSegment;
	face = new Face[numFaces];
	int i = 0;
	//around
	for (int i = 0; i < nSegment; i++) {
		face[i].nVerts = 4;
		face[i].vert = new VertexID[face[i].nVerts];
		face[i].vert[0].vertIndex = i;
		face[i].vert[1].vertIndex = nSegment + i;
		if (i == nSegment - 1) {
			face[i].vert[2].vertIndex = nSegment;
			face[i].vert[3].vertIndex = 0;
		}
		else {
			face[i].vert[2].vertIndex = nSegment + i + 1;
			face[i].vert[3].vertIndex = i + 1;
		}
		//decide color face
		/* for (int j = 0; j<face[i].nVerts; j++)
		face[0].vert[j].colorIndex = rand() % 14;*/
	}
	//bottom
	for (int i = nSegment; i < 2 * nSegment; i++) {
		face[i].nVerts = 3;
		face[i].vert = new VertexID[face[i].nVerts];
		face[i].vert[0].vertIndex = 2 * nSegment;
		face[i].vert[1].vertIndex = i - nSegment;
		if (i == 2 * nSegment - 1)
			face[i].vert[2].vertIndex = i - nSegment - nSegment + 1;
		else
			face[i].vert[2].vertIndex = i - nSegment + 1;
		/* for (int j = 0; j<face[i].nVerts; j++)
		face[0].vert[j].colorIndex = rand() % 14;*/
	}
	//top
	for (int i = 2 * nSegment; i < 3 * nSegment; i++) {
		face[i].nVerts = 3;
		face[i].vert = new VertexID[face[i].nVerts];
		face[i].vert[0].vertIndex = 2 * nSegment + 1;
		face[i].vert[1].vertIndex = i - nSegment;
		if (i == 3 * nSegment - 1)
			face[i].vert[2].vertIndex = i - nSegment - nSegment + 1;
		else
			face[i].vert[2].vertIndex = i - nSegment + 1;
		/*for (int j = 0; j<face[i].nVerts; j++)
		face[0].vert[j].colorIndex = rand() % 14;*/
	}

}

void Mesh::CreateTorus(int nSlice, int nStack, float A, float D) {
	numVerts = nStack*nSlice;
	pt = new Point3[numVerts];

	float alpha = 360 / nSlice;
	float theta = 360 / nStack;
	int v = 0;
	for (int i = 0; i< nStack; i++) {
		for (int j = 0; j < nSlice; j++) {

			pt[v].set((D + A * cos(j * DEG2RAD * theta)) * cos(alpha * i * DEG2RAD),
				(D + A * cos(j * DEG2RAD * theta)) * sin(alpha * i * DEG2RAD), A * sin(j * DEG2RAD * theta));

			v++;
		}
	}

	numFaces = nSlice*nStack;
	face = new Face[numFaces];

	for (int i = 0; i<nStack; i++) {
		for (int j = 0; j<nSlice; j++) {
			int count = i*nSlice + j;
			face[count].nVerts = 4;
			face[count].vert = new VertexID[4];

			face[count].vert[0].vertIndex = i * nSlice + j;
			face[count].vert[1].vertIndex = (i + 1) % nStack * nSlice + j;
			face[count].vert[2].vertIndex = (i + 1) % nStack * nSlice + (j + 1) % nSlice;
			face[count].vert[3].vertIndex = i * nSlice + (j + 1) % nSlice;


		}
	}




}

void Mesh::DrawWireframe()
{
	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	for (int f = 0; f < numFaces; f++)
	{
		glBegin(GL_POLYGON);
		for (int v = 0; v < face[f].nVerts; v++)
		{
			int		iv = face[f].vert[v].vertIndex;

			glVertex3f(pt[iv].x, pt[iv].y, pt[iv].z);
		}
		glEnd();
	}
}
bool smooth = false;
void Mesh::Draw() {
	for (int f = 0; f < numFaces; f++) {

		glBegin(GL_POLYGON);

		for (int v = 0; v < face[f].nVerts; v++) {
			int		iv = face[f].vert[v].vertIndex;
			if (smooth)
				glNormal3f(pt[iv].vertexNorm.x, pt[iv].vertexNorm.y, pt[iv].vertexNorm.z);
			else
				glNormal3f(face[f].facenorm.x, face[f].facenorm.y, face[f].facenorm.z);

			glVertex3f(pt[iv].x, pt[iv].y, pt[iv].z);
		}
		glEnd();

	}
}



void Mesh::CalculateFacesNorm() {
	for (int f = 0; f < numFaces; f++) {
		double mx = 0, my = 0, mz = 0;
		for (int v = 0; v < face[f].nVerts; v++) {
			int		iv, ivn;
			iv = face[f].vert[v].vertIndex;
			ivn = (v == face[f].nVerts - 1) ? face[f].vert[0].vertIndex : face[f].vert[v + 1].vertIndex;
			mx += (pt[iv].y - pt[ivn].y)*(pt[iv].z + pt[ivn].z);
			my += (pt[iv].z - pt[ivn].z)*(pt[iv].x + pt[ivn].x);
			mz += (pt[iv].x - pt[ivn].x)*(pt[iv].y + pt[ivn].y);
		}

		face[f].facenorm.set(mx, -my, mz);
		face[f].facenorm.normalize();
	}
}

void Mesh::CalculateVertexNorm() {
	for (int v = 0; v < numVerts; v++) {
		double mx = 0, my = 0, mz = 0;
		for (int f = 0; f < numFaces; f++) {

			for (int vf = 0; vf < face[f].nVerts; vf++) {
				if (face[f].vert[vf].vertIndex == v) {
					mx += face[f].facenorm.x;
					my += face[f].facenorm.y;
					mz += face[f].facenorm.z;
				}
			}
		}
		pt[v].vertexNorm.set(mx, my, mz);
		pt[v].vertexNorm.normalize();
	}
}


//main


int	screenWidth = 600;
int	screenHeight = 600;

bool	bWireFrame = false;

float	baseRadius = 0.8;
float	baseHeight = 0.2;
float	baseRotateStep = 5;

float	supportRadius = 0.1;
float	supportHeight = 0.5;

float   frameRadius = 0.11;
float   frameHeight = 2;

float   gimbal1Radius = 0.11;
float   gimbal1Height = 1.5 - 0.11;

float   gimbal2Radius = 0.11;
float   gimbal2Height = gimbal1Height - supportHeight / 1.5 - frameRadius;

float   axisHeight = gimbal2Height * 2;
float   axisRadius = frameRadius;
int alpha = 0;
float distances = 55;

float cameraEyeX = distances*sin(alpha*3.14 / 180);
float cameraEyeY = (frameHeight + frameRadius) * 6;
float cameraEyeZ = distances*cos(alpha*3.14 / 180);
float cameraUpX = 0;
float cameraUpY = 1;
float cameraUpZ = 0;
float cameraCenterX = 0;
float cameraCenterY = frameHeight;
float cameraCenterZ = 0;

bool first = true;
bool animation = false;
bool view = false;


Mesh	base;
Mesh	support;
Mesh    frame;
Mesh    frameRight;
Mesh    topBot;
Mesh    gimbal1;
Mesh    gimbal2;

Mesh    axis;
Mesh    roto;

Texture   floorTex;

void processTimer(int value) {
	if (animation == false) return;
	base.rotateY += 0.5;
	if (base.rotateY > 360)
		base.rotateY -= 360;
	gimbal1.rotateX += 0.5;
	if (base.rotateX>360)
		gimbal1.rotateX -= 360;
	gimbal2.rotateY += 0.5;
	if (gimbal2.rotateY>360)
		gimbal2.rotateY -= 360;
	roto.rotateX -= 3;
	if (roto.rotateX>360) roto.rotateX -= 360;

	glutTimerFunc(60, processTimer, value);
	glutPostRedisplay();
}
void setupMaterial(float ambient[], float diffuse[], float specular[], float shiness)
{
	glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, ambient);
	glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diffuse);
	glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, specular);
	glMaterialf(GL_FRONT_AND_BACK, GL_SHININESS, shiness);
}

void loadTextures(void) {
	bool status = LoadTGA(&floorTex, "MARBLE.tga");
	if (status) {
		glGenTextures(1, &floorTex.texID);
		glBindTexture(GL_TEXTURE_2D, floorTex.texID);

		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, floorTex.width,
			floorTex.height, 0,
			GL_RGB, GL_UNSIGNED_BYTE, floorTex.imageData);

		if (floorTex.imageData)
			free(floorTex.imageData);
	}
}
bool twoLight = true;

void myKeyboard(unsigned char key, int x, int y)
{
	switch (key)
	{
	case '1':
		base.rotateY += baseRotateStep;
		if (base.rotateY > 360)
			base.rotateY -= 360;
		break;
	case '2':
		base.rotateY -= baseRotateStep;
		if (base.rotateY < 0)
			base.rotateY += 360;
		break;
	case '3':
		gimbal1.rotateX += baseRotateStep;
		if (base.rotateX>360)
			gimbal1.rotateX -= 360;
		break;
	case '4':
		gimbal1.rotateX -= baseRotateStep;
		if (gimbal1.rotateX<0)
			gimbal1.rotateX += 360;
		break;
	case '5':
		gimbal2.rotateY += baseRotateStep;
		if (gimbal2.rotateY>360)
			gimbal2.rotateY -= 360;
		break;
	case '6':
		gimbal2.rotateY -= baseRotateStep;
		if (gimbal2.rotateY<0)
			gimbal2.rotateY += 360;
		break;
	case '7':
		roto.rotateX += baseRotateStep;
		if (roto.rotateX>360) roto.rotateX -= 360;
		break;
	case '8':
		roto.rotateX -= baseRotateStep;
		if (roto.rotateX<0) roto.rotateX += 360;
		break;

	case 'r':
	case 'R':
		base.rotateY = gimbal1.rotateX = gimbal2.rotateY = roto.rotateX = 0;
		break;
	case '+':
		if (first) {
			distances += 0.2;

			cameraEyeX = distances * sin(alpha * 3.14 / 180);
			cameraEyeY += 0.025;
			cameraEyeZ = distances * cos(alpha * 3.14 / 180);
			// if (distances < frameRadius) first = false;
		}
		else {
			distances -= 0.2;
			cameraEyeX = distances * sin(alpha * 3.14 / 180);
			cameraEyeY -= 0.025;
			cameraEyeZ = distances * cos(alpha * 3.14 / 180);
		}

		break;
	case '-':
		if (first) {
			distances -= 0.2;

			cameraEyeX = distances * sin(alpha * 3.14 / 180);
			cameraEyeY -= 0.025;
			cameraEyeZ = distances * cos(alpha * 3.14 / 180);
			if (distances<frameRadius) first = false;
		}
		else {

			distances += 0.2;

			cameraEyeX = distances * sin(alpha * 3.14 / 180);
			cameraEyeY += 0.025;
			cameraEyeZ = distances * cos(alpha * 3.14 / 180);

		}

		break;
	case 'd':
	case 'D':
		twoLight = !twoLight;
		break;

	case 's':
	case 'S':
		smooth = true;
		break;
	case 'f':
	case 'F':
		smooth = false;
		break;
	case 'a':
	case 'A':
		animation = !animation;
		if (animation == true)  glutTimerFunc(60, processTimer, 100);
		break;




	}
	glutPostRedisplay();
}

//int i=0;

void specialInput(int key, int x, int y)
{
	switch (key)
	{
	case GLUT_KEY_UP:
		cameraEyeY += 0.5;
		break;
	case GLUT_KEY_DOWN:
		cameraEyeY -= 0.5;
		break;
	case GLUT_KEY_RIGHT:
		alpha -= 5;
		if (alpha<0) alpha += 360;

		cameraEyeX = distances*sin(alpha*3.14 / 180);
		cameraEyeZ = distances*cos(alpha*3.14 / 180);
		break;
	case GLUT_KEY_LEFT:
		alpha += 5;
		if (alpha>360) alpha -= 360;

		cameraEyeX = distances*sin(alpha*3.14 / 180);
		cameraEyeZ = distances*cos(alpha*3.14 / 180);
		break;
	}

	glutPostRedisplay();
}

void drawBase(float ambient[4], float diffuse[4], float specular[4], float shiness)
{
	glPushMatrix();

	//glTranslated(0, 0, 0);
	glRotatef(base.rotateY, 0, 1, 0);


	diffuse[0] = 1.0;
	diffuse[1] = 0.0;
	diffuse[2] = 0.0;


	setupMaterial(ambient, diffuse, specular, shiness);

	base.Draw();


	glPopMatrix();
}


void drawSupport(float ambient[4], float diffuse[4], float specular[4], float shiness)
{
	glPushMatrix();

	glTranslated(0, baseHeight, 0);
	glRotatef(base.rotateY, 0, 1, 0);



	diffuse[0] = 1.0;
	diffuse[1] = 0.0;
	diffuse[2] = 0.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	support.Draw();

	glPopMatrix();
}
void drawFrame(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();
	glTranslated(0, supportHeight + baseHeight + frameHeight + frameRadius, 0);
	glRotatef(base.rotateY, 0, 1, 0);




	diffuse[0] = 1.0;
	diffuse[1] = 0.0;
	diffuse[2] = 0.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	frame.Draw();



	glPopMatrix();
}
void drawSupportRight(float height) {
	glPushMatrix();

	//glTranslated(0, supportHeight + baseHeight+frameHeight+frameRadius,frameHeight-frameRadius);
	glRotatef(90, 0, 0, 1);
	glTranslated(supportHeight + baseHeight + height + frameRadius, 0, 0);
	glRotatef(base.rotateY, 1, 0, 0);
	glTranslated(0, -height, 0);


	frameRight.Draw();


	glPopMatrix();
}
void drawSupportLeft(float height) {
	glPushMatrix();

	//glTranslated(0, supportHeight + baseHeight+frameHeight+frameRadius,frameHeight-frameRadius);
	glRotatef(-90, 0, 0, 1);
	glTranslated(-(supportHeight + baseHeight + height + frameRadius), 0, 0);
	glRotatef(-base.rotateY, 1, 0, 0);
	glTranslated(0, -height, 0);


	frameRight.Draw();



	glPopMatrix();
}

void drawGimbal1(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();
	glRotatef(base.rotateY, 0, 1, 0);


	glTranslated(0, supportHeight + baseHeight + frameHeight + frameRadius, 0);

	glRotated(gimbal1.rotateX, 1, 0, 0);







	diffuse[0] = 0.0;
	diffuse[1] = 0.0;
	diffuse[2] = 1.0;
	setupMaterial(ambient, diffuse, specular, shiness);

	gimbal1.Draw();

	glPopMatrix();
}

void drawSupportTop(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();
	glRotatef(base.rotateY, 0, 1, 0);

	glTranslated(0, baseHeight + supportHeight + frameHeight + frameRadius, 0);
	glRotated(gimbal1.rotateX, 1, 0, 0);

	glTranslated(0, gimbal1Height - supportHeight / 1.5, 0);
	//glTranslated(0,gimbal1Height,0);
	//glTranslated(0,0,2);


	diffuse[0] = 0.0;
	diffuse[1] = 0.0;
	diffuse[2] = 1.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	topBot.Draw();


	glPopMatrix();
}
void drawSupportBot(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();

	glRotatef(base.rotateY, 0, 1, 0);
	glTranslated(0, baseHeight + supportHeight + frameHeight + frameRadius, 0);
	glRotated(gimbal1.rotateX, 1, 0, 0);
	glTranslated(0, -gimbal1Height, 0);


	diffuse[0] = 0.0;
	diffuse[1] = 0.0;
	diffuse[2] = 1.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	topBot.Draw();


	glPopMatrix();
}

void drawGimbal2(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();

	glRotatef(base.rotateY, 0, 1, 0);



	glTranslated(0, baseHeight + supportHeight + frameHeight + frameRadius, 0);
	glRotatef(gimbal1.rotateX, 1, 0, 0);

	glRotatef(gimbal2.rotateY, 0, 1, 0);



	diffuse[0] = 0.0;
	diffuse[1] = 1.0;
	diffuse[2] = 0.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	gimbal2.Draw();



	glPopMatrix();
}
void drawAxis(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();

	// glRotatef(gimbal2.rotateY,0,1,0);

	glRotatef(-90, 0, 0, 1);
	//glTranslated(0,0,0);

	glTranslated(-(baseHeight + supportHeight + frameHeight + axisRadius), 0, 0);

	glRotatef(base.rotateY, -1, 0, 0);
	glRotatef(gimbal1.rotateX, 0, 1, 0);

	glRotatef(gimbal2.rotateY, -1, 0, 0);
	glTranslated(0, -axisHeight / 2, 0);





	diffuse[0] = 0.0;
	diffuse[1] = 1.0;
	diffuse[2] = 0.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	axis.Draw();

	glPopMatrix();
}

void drawRoto(float ambient[4], float diffuse[4], float specular[4], float shiness) {
	glPushMatrix();
	// glRotatef(base.rotateY,0,1,0);

	glRotatef(-90, 0, 0, 1);
	glTranslated(-(baseHeight + supportHeight + frameHeight + frameRadius), 0, 0);
	glRotatef(base.rotateY, -1, 0, 0);
	glRotatef(gimbal1.rotateX, 0, 1, 0);

	glRotatef(gimbal2.rotateY, -1, 0, 0);
	glRotatef(-roto.rotateX, 0, 1, 0);
	glTranslated(0, -baseHeight / 2, 0);


	diffuse[0] = 1.0;
	diffuse[1] = 0.0;
	diffuse[2] = 1.0;
	setupMaterial(ambient, diffuse, specular, shiness);
	roto.Draw();


	glPopMatrix();
}

void drawCoordinate() {
	glColor3f(1, 0, 0);
	glBegin(GL_LINES);
	glVertex3f(-frameHeight*1.5, 0, 0);
	glVertex3f(frameHeight*1.5, 0, 0);
	glColor3f(0, 1, 0);
	glVertex3f(0, 0, 0);
	glVertex3f(0, frameHeight * 2, 0);
	glColor3f(0, 0, 1);
	glVertex3f(0, 0, -frameHeight*1.5);
	glVertex3f(0, 0, frameHeight*1.5);
	glEnd();
}



void myInit()
{
	float	fHalfSize = 4;

	glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
	glColor3f(0.0f, 0.0f, 0.0f);
	//glEnable(GL_SHADE_MODEL);
	//	if (smooth)

	//else
	//		glShadeModel(GL_FLAT);

	//glFrontFace(GL_CCW);
	glEnable(GL_DEPTH_TEST);


	//glShadeModel(GL_FLAT);

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	//  glOrtho(-fHalfSize*2, fHalfSize*2, -fHalfSize*2, fHalfSize*2, -1000, 1000);
	// glOrtho(-fHalfSize, fHalfSize, -fHalfSize/1.5, fHalfSize*1.5, -1000, 1000);
	gluPerspective(10, 1, 5, -7);


	// glFrustum(-1.5,1.5,-2,2,1,20);
	glMatrixMode(GL_MODELVIEW);

}

void textTure() {
	//glClear(GL_DEPTH_BUFFER_BIT);
	loadTextures();
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	glDisable(GL_LIGHTING);

	glEnable(GL_TEXTURE_2D);
	glBindTexture(GL_TEXTURE_2D, floorTex.texID);
	glColor4f(1, 1, 1, 0.6);
	glBegin(GL_POLYGON);
	glTexCoord2d(1.0, 1.0);
	glVertex3d(20.0, 0, 20.0);
	glTexCoord2d(1.0, -1.0);
	glVertex3d(20.0, 0, -20.0);
	glTexCoord2d(-1.0, -1.0);
	glVertex3d(-20.0, 0, -20.0);
	glTexCoord2d(-1.0, 1.0);
	glVertex3d(-20.0, 0, 20.0);
	glEnd();
	glDisable(GL_TEXTURE_2D);
	glEnable(GL_LIGHTING);
	glDisable(GL_BLEND);
}

void light() {
	GLfloat	lightDiffuse[] = { 1.0f, 1.0f, 1.0f, 1.0f };
	GLfloat	lightSpecular[] = { 2.5f, 2.5f,2.5f, 1.0f };
	GLfloat	lightAmbient[] = { 1.5f,1.5f,1.5f, 1.0f };
	GLfloat light_position1[] = { 0.0f, 5.0f, 5.0f, 0.0f };


	GLfloat light_position2[] = { -3.0f, 5.0f, -5.0f, 0.0f };
	glLightfv(GL_LIGHT0, GL_POSITION, light_position1);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, lightDiffuse);
	glLightfv(GL_LIGHT0, GL_AMBIENT, lightAmbient);
	glLightfv(GL_LIGHT0, GL_SPECULAR, lightSpecular);

	glLightfv(GL_LIGHT1, GL_POSITION, light_position2);
	glLightfv(GL_LIGHT1, GL_DIFFUSE, lightDiffuse);
	glLightfv(GL_LIGHT1, GL_AMBIENT, lightAmbient);
	glLightfv(GL_LIGHT1, GL_SPECULAR, lightSpecular);

	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);


	if (twoLight) {
		glEnable(GL_LIGHT1);

	}
	else {
		glDisable(GL_LIGHT1);
	}

}



void drawAll() {



	//glShadeModel(GL_FLAT);
	//drawCoordinate();


	float ambient[4] = { 0.0, 0.0, 0.0 };
	float diffuse[4] = { 0.0, 0.0, 0.0 };
	float specular[4] = { 0.25, 0.25, 0.2 };
	float shiness = 15.0;



	// drawAxis();
	drawBase(ambient, diffuse, specular, shiness);
	drawSupport(ambient, diffuse, specular, shiness);

	drawFrame(ambient, diffuse, specular, shiness);
	drawSupportRight(frameHeight);
	drawSupportLeft(frameHeight);
	drawSupportTop(ambient, diffuse, specular, shiness);
	drawSupportBot(ambient, diffuse, specular, shiness);



	drawGimbal1(ambient, diffuse, specular, shiness);



	drawGimbal2(ambient, diffuse, specular, shiness);

	drawAxis(ambient, diffuse, specular, shiness);

	drawRoto(ambient, diffuse, specular, shiness);


}



void shadowFloorBehind()
{
	glDisable(GL_LIGHTING);
	GLfloat shadowMax[4][4];
	GLfloat drawFloor[4] = { 0, 0.1, 0, -0.001 };
	GLfloat lightpos[] = { 1.0f, 5.0f, 8.0f, 0.0f };
	GLfloat dot;


	dot = drawFloor[0] * lightpos[0] +
		drawFloor[1] * lightpos[1] +
		drawFloor[2] * lightpos[2] +
		drawFloor[3] * lightpos[3];

	shadowMax[0][0] = dot - lightpos[0] * drawFloor[0];
	shadowMax[1][0] = 0.f - lightpos[0] * drawFloor[1];
	shadowMax[2][0] = 0.f - lightpos[0] * drawFloor[2];
	shadowMax[3][0] = 0.f - lightpos[0] * drawFloor[3];

	shadowMax[0][1] = 0.f - lightpos[1] * drawFloor[0];
	shadowMax[1][1] = dot - lightpos[1] * drawFloor[1];
	shadowMax[2][1] = 0.f - lightpos[1] * drawFloor[2];
	shadowMax[3][1] = 0.f - lightpos[1] * drawFloor[3];

	shadowMax[0][2] = 0.f - lightpos[2] * drawFloor[0];
	shadowMax[1][2] = 0.f - lightpos[2] * drawFloor[1];
	shadowMax[2][2] = dot - lightpos[2] * drawFloor[2];
	shadowMax[3][2] = 0.f - lightpos[2] * drawFloor[3];

	shadowMax[0][3] = 0.f - lightpos[3] * drawFloor[0];
	shadowMax[1][3] = 0.f - lightpos[3] * drawFloor[1];
	shadowMax[2][3] = 0.f - lightpos[3] * drawFloor[2];
	shadowMax[3][3] = dot - lightpos[3] * drawFloor[3];
	glPushMatrix();
	glColor4f(0, 0, 0, 1);
	glMultMatrixf((GLfloat*)shadowMax);
	drawAll();
	glPopMatrix();
	glEnable(GL_LIGHTING);
}
void shadowFloorFront()
{
	glDisable(GL_LIGHTING);
	GLfloat shadowMax[4][4];
	GLfloat drawFloor[4] = { 0, 0.1, 0, -0.001 };
	GLfloat lightpos[] = { -3.0f, 5.0f, -8.0f, 0.0f };
	GLfloat dot;


	dot = drawFloor[0] * lightpos[0] +
		drawFloor[1] * lightpos[1] +
		drawFloor[2] * lightpos[2] +
		drawFloor[3] * lightpos[3];

	shadowMax[0][0] = dot - lightpos[0] * drawFloor[0];
	shadowMax[1][0] = 0.f - lightpos[0] * drawFloor[1];
	shadowMax[2][0] = 0.f - lightpos[0] * drawFloor[2];
	shadowMax[3][0] = 0.f - lightpos[0] * drawFloor[3];

	shadowMax[0][1] = 0.f - lightpos[1] * drawFloor[0];
	shadowMax[1][1] = dot - lightpos[1] * drawFloor[1];
	shadowMax[2][1] = 0.f - lightpos[1] * drawFloor[2];
	shadowMax[3][1] = 0.f - lightpos[1] * drawFloor[3];

	shadowMax[0][2] = 0.f - lightpos[2] * drawFloor[0];
	shadowMax[1][2] = 0.f - lightpos[2] * drawFloor[1];
	shadowMax[2][2] = dot - lightpos[2] * drawFloor[2];
	shadowMax[3][2] = 0.f - lightpos[2] * drawFloor[3];

	shadowMax[0][3] = 0.f - lightpos[3] * drawFloor[0];
	shadowMax[1][3] = 0.f - lightpos[3] * drawFloor[1];
	shadowMax[2][3] = 0.f - lightpos[3] * drawFloor[2];
	shadowMax[3][3] = dot - lightpos[3] * drawFloor[3];
	glPushMatrix();
	glColor4f(0, 0, 0, 1);
	glMultMatrixf((GLfloat*)shadowMax);
	drawAll();
	glPopMatrix();
	glEnable(GL_LIGHTING);
}
void myDisplay() {

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	gluLookAt(cameraEyeX, cameraEyeY, cameraEyeZ, cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
		cameraUpZ);
	glViewport(0, 0, screenWidth, screenHeight);

	if (smooth)
		glShadeModel(GL_SMOOTH);
	else
		glShadeModel(GL_FLAT);

	light();

	//================================
	glScalef(1.0, -1.0, 1.0);
	shadowFloorBehind();
	if (twoLight)
		shadowFloorFront();



	drawAll();
	glClear(GL_DEPTH_BUFFER_BIT);
	textTure();
	glScalef(1.0, -1.0, 1.0);
	drawAll();

	glScalef(1.0, -1.0, 1.0);
	shadowFloorBehind();
	if (twoLight)
		shadowFloorFront();

	//================================

	glFlush();








	glutSwapBuffers();

}


int main(int argc, char** argv)
{
	cout << "1, 2: Rotate the base" << endl;
	cout << "3, 4: Rotate the gimbal 1" << endl;
	cout << "5, 6: Rotate the gimbal 2" << endl;
	cout << "7, 8: Rotate the rotor" << endl;
	cout << "R, r: Reset the Gyroscope" << endl;
	cout << "D, d: Turn light" << endl;
	cout << " S, s: paint smooth" << endl;
	cout << "F,f: paint flat" << endl;

	glutInit(&argc, (char**)argv); //initialize the tool kit
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);//set the display mode
	glutInitWindowSize(screenWidth, screenHeight); //set window size
	glutInitWindowPosition(100, 100); // set window position on screen
	glutCreateWindow("1410407- NGUYEN KHANH CONG"); // open the screen window

	base.CreateCylinder(20, baseHeight, baseRadius);

	base.CalculateFacesNorm();
	base.CalculateVertexNorm();

	support.CreateCylinder(20, supportHeight, supportRadius);
	support.CalculateFacesNorm();
	support.CalculateVertexNorm();

	frame.CreateTorus(40, 40, frameRadius, frameHeight);
	frame.CalculateFacesNorm();
	frame.CalculateVertexNorm();

	frameRight.CreateCylinder(10, supportHeight, frameRadius);
	frameRight.CalculateFacesNorm();
	frameRight.CalculateVertexNorm();

	gimbal1.CreateTorus(40, 40, gimbal1Radius, gimbal1Height);
	gimbal1.CalculateFacesNorm();
	gimbal1.CalculateVertexNorm();

	topBot.CreateCylinder(20, supportHeight / 1.5, frameRadius);
	topBot.CalculateFacesNorm();
	topBot.CalculateVertexNorm();

	gimbal2.CreateTorus(40, 40, gimbal2Radius, gimbal2Height);

	gimbal2.CalculateFacesNorm();
	gimbal2.CalculateVertexNorm();

	axis.CreateCylinder(20, axisHeight, axisRadius);
	axis.CalculateFacesNorm();
	axis.CalculateVertexNorm();

	roto.CreateCylinder(6, baseHeight, baseRadius / 1.5);
	roto.CalculateFacesNorm();
	roto.CalculateVertexNorm();

	myInit();
	glutKeyboardFunc(myKeyboard);
	glutSpecialFunc(specialInput);
	glutDisplayFunc(myDisplay);

	// glutTimerFunc(1000,processTimer,10);

	glutMainLoop();
	return 0;
}
