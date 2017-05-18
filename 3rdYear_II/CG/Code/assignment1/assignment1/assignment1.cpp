

#include <iostream>
#include <gl/GL.h>
#include <gl/glut.h>
#include <math.h>


using namespace std;
//supportClass.h

class Point3
{
public:
	float x, y, z;
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

	void DrawColor();

	void CreateCylinder(int nSegment, float fHeight, float fRadius);


	void CreateTorus(int nSlice, int nStack, float A, float D);

	void SetColor(int colorIdx);
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

void Mesh::DrawColor()
{
	glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
	for (int f = 0; f < numFaces; f++)
	{
		glBegin(GL_POLYGON);
		for (int v = 0; v < face[f].nVerts; v++)
		{
			int		iv = face[f].vert[v].vertIndex;
			int		ic = face[f].vert[v].colorIndex;

			//ic = f % COLORNUM;

			glColor3f(ColorArr[ic][0], ColorArr[ic][1], ColorArr[ic][2]);
			glVertex3f(pt[iv].x, pt[iv].y, pt[iv].z);
		}
		glEnd();
	}
}
void Mesh::SetColor(int colorIdx) {
	for (int f = 0; f < numFaces; f++)
	{
		for (int v = 0; v < face[f].nVerts; v++)
		{
			face[f].vert[v].colorIndex = colorIdx;
		}
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
float distances = 40;

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
	case 'w':
	case 'W':
		bWireFrame = !bWireFrame;
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
	case 'a':
	case 'A':
		animation = !animation;
		if (animation == true)  glutTimerFunc(60, processTimer, 100);
		break;
	case 'v':
	case 'V':
		view = !view;

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

void drawBase()
{
	glPushMatrix();

	//glTranslated(0, 0, 0);
	glRotatef(base.rotateY, 0, 1, 0);

	if (bWireFrame)
		base.DrawWireframe();
	else
		base.DrawColor();

	glPopMatrix();
}


void drawSupport()
{
	glPushMatrix();

	glTranslated(0, baseHeight, 0);
	glRotatef(base.rotateY, 0, 1, 0);

	if (bWireFrame)
		support.DrawWireframe();
	else
		support.DrawColor();

	glPopMatrix();
}
void drawFrame() {
	glPushMatrix();
	glTranslated(0, supportHeight + baseHeight + frameHeight + frameRadius, 0);
	glRotatef(base.rotateY, 0, 1, 0);



	if (bWireFrame) {
		frame.DrawWireframe();

	}
	else {
		frame.DrawColor();

	}

	glPopMatrix();
}
void drawSupportRight(float height) {
	glPushMatrix();

	//glTranslated(0, supportHeight + baseHeight+frameHeight+frameRadius,frameHeight-frameRadius);
	glRotatef(90, 0, 0, 1);
	glTranslated(supportHeight + baseHeight + height + frameRadius, 0, 0);
	glRotatef(base.rotateY, 1, 0, 0);
	glTranslated(0, -height, 0);
	if (bWireFrame) {
		frameRight.DrawWireframe();

	}
	else {
		frameRight.DrawColor();

	}
	glPopMatrix();
}
void drawSupportLeft(float height) {
	glPushMatrix();

	//glTranslated(0, supportHeight + baseHeight+frameHeight+frameRadius,frameHeight-frameRadius);
	glRotatef(-90, 0, 0, 1);
	glTranslated(-(supportHeight + baseHeight + height + frameRadius), 0, 0);
	glRotatef(-base.rotateY, 1, 0, 0);
	glTranslated(0, -height, 0);
	if (bWireFrame) {
		frameRight.DrawWireframe();

	}
	else {
		frameRight.DrawColor();

	}

	glPopMatrix();
}

void drawGimbal1() {
	glPushMatrix();
	glRotatef(base.rotateY, 0, 1, 0);


	glTranslated(0, supportHeight + baseHeight + frameHeight + frameRadius, 0);

	glRotated(gimbal1.rotateX, 1, 0, 0);


	if (bWireFrame) {
		gimbal1.DrawWireframe();

	}
	else {
		gimbal1.DrawColor();
	}
	glPopMatrix();
}

void drawSupportTop() {
	glPushMatrix();
	glRotatef(base.rotateY, 0, 1, 0);

	glTranslated(0, baseHeight + supportHeight + frameHeight + frameRadius, 0);
	glRotated(gimbal1.rotateX, 1, 0, 0);

	glTranslated(0, gimbal1Height - supportHeight / 1.5, 0);
	//glTranslated(0,gimbal1Height,0);
	//glTranslated(0,0,2);
	if (bWireFrame) {
		topBot.DrawWireframe();

	}
	else {
		topBot.DrawColor();

	}
	glPopMatrix();
}
void drawSupportBot() {
	glPushMatrix();

	glRotatef(base.rotateY, 0, 1, 0);
	glTranslated(0, baseHeight + supportHeight + frameHeight + frameRadius, 0);
	glRotated(gimbal1.rotateX, 1, 0, 0);
	glTranslated(0, -gimbal1Height, 0);
	if (bWireFrame) {
		topBot.DrawWireframe();

	}
	else {
		topBot.DrawColor();

	}
	glPopMatrix();
}

void drawGimbal2() {
	glPushMatrix();

	glRotatef(base.rotateY, 0, 1, 0);



	glTranslated(0, baseHeight + supportHeight + frameHeight + frameRadius, 0);
	glRotatef(gimbal1.rotateX, 1, 0, 0);

	glRotatef(gimbal2.rotateY, 0, 1, 0);

	if (bWireFrame) {
		gimbal2.DrawWireframe();

	}
	else {
		gimbal2.DrawColor();

	}

	glPopMatrix();
}
void drawAxis() {
	glPushMatrix();

	// glRotatef(gimbal2.rotateY,0,1,0);

	glRotatef(-90, 0, 0, 1);
	//glTranslated(0,0,0);

	glTranslated(-(baseHeight + supportHeight + frameHeight + axisRadius), 0, 0);

	glRotatef(base.rotateY, -1, 0, 0);
	glRotatef(gimbal1.rotateX, 0, 1, 0);

	glRotatef(gimbal2.rotateY, -1, 0, 0);
	glTranslated(0, -axisHeight / 2, 0);



	if (bWireFrame) {
		axis.DrawWireframe();
	}
	else {
		axis.DrawColor();
	}
	glPopMatrix();
}

void drawRoto() {
	glPushMatrix();
	// glRotatef(base.rotateY,0,1,0);

	glRotatef(-90, 0, 0, 1);
	glTranslated(-(baseHeight + supportHeight + frameHeight + frameRadius), 0, 0);
	glRotatef(base.rotateY, -1, 0, 0);
	glRotatef(gimbal1.rotateX, 0, 1, 0);

	glRotatef(gimbal2.rotateY, -1, 0, 0);
	glRotatef(-roto.rotateX, 0, 1, 0);
	glTranslated(0, -baseHeight / 2, 0);
	if (bWireFrame) roto.DrawWireframe();
	else roto.DrawColor();

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

	glFrontFace(GL_CCW);
	glEnable(GL_DEPTH_TEST);

	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	//  glOrtho(-fHalfSize*2, fHalfSize*2, -fHalfSize*2, fHalfSize*2, -1000, 1000);
	// glOrtho(-fHalfSize, fHalfSize, -fHalfSize/1.5, fHalfSize*1.5, -1000, 1000);
	gluPerspective(10, 1, 5, -7);



	// glFrustum(-1.5,1.5,-2,2,1,20);
	glMatrixMode(GL_MODELVIEW);
}

void drawAll() {
	drawCoordinate();
	drawAxis();
	drawBase();
	drawSupport();

	drawFrame();
	drawSupportRight(frameHeight);
	drawSupportLeft(frameHeight);

	drawGimbal1();
	drawSupportTop();
	drawSupportBot();

	drawGimbal2();
	drawAxis();

	drawRoto();
}
void myDisplay() {

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	if (!view) {
		gluLookAt(cameraEyeX, cameraEyeY, cameraEyeZ, cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
			cameraUpZ);
		glViewport(0, 0, screenWidth, screenHeight);
		drawAll();
	}
	else {
		//left below
		glViewport(0, 0, 300, 300);
		glLoadIdentity();
		gluLookAt(cameraEyeX, cameraEyeY, cameraEyeZ, cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
			cameraUpZ);


		drawAll();

		//right below
		/* gluLookAt(cameraEyeX, cameraEyeY, cameraEyeZ, cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
		cameraUpZ);*/
		glViewport(300, 0, 300, 300);
		glLoadIdentity();
		gluLookAt(distances*sin((alpha + 90)*3.14 / 180), cameraEyeY, distances*cos((alpha + 90)*3.14 / 180), cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
			cameraUpZ);
		drawAll();

		//right above
		glViewport(300, 300, 300, 300);
		glLoadIdentity();
		gluLookAt(cameraEyeX, cameraEyeY, cameraEyeZ, cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
			cameraUpZ);
		drawAll();

		//left above
		glViewport(0, 300, 300, 300);
		glLoadIdentity();
		gluLookAt(cameraEyeX, cameraEyeY, cameraEyeZ, cameraCenterX, cameraCenterY, cameraCenterZ, cameraUpX, cameraUpY,
			cameraUpZ);
		drawAll();

	}
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
	cout << "W, w: Switch between wireframe and solid mode" << endl;

	glutInit(&argc, (char**)argv); //initialize the tool kit
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);//set the display mode
	glutInitWindowSize(screenWidth, screenHeight); //set window size
	glutInitWindowPosition(100, 100); // set window position on screen
	glutCreateWindow("Lab3-2016-2017"); // open the screen window

	base.CreateCylinder(20, baseHeight, baseRadius);
	base.SetColor(2);

	support.CreateCylinder(20, supportHeight, supportRadius);
	support.SetColor(3);

	frame.CreateTorus(60, 60, frameRadius, frameHeight);
	frame.SetColor(4);

	frameRight.CreateCylinder(4, supportHeight, frameRadius);
	frameRight.SetColor(4);

	gimbal1.CreateTorus(60, 60, gimbal1Radius, gimbal1Height);
	gimbal1.SetColor(1);

	topBot.CreateCylinder(4, supportHeight / 1.5, frameRadius);
	topBot.SetColor(1);

	gimbal2.CreateTorus(60, 60, gimbal2Radius, gimbal2Height);
	gimbal2.SetColor(0);

	axis.CreateCylinder(10, axisHeight, axisRadius);
	axis.SetColor(0);

	roto.CreateCylinder(6, baseHeight, baseRadius / 1.5);
	roto.SetColor(2);

	myInit();
	glutKeyboardFunc(myKeyboard);
	glutSpecialFunc(specialInput);
	glutDisplayFunc(myDisplay);

	// glutTimerFunc(1000,processTimer,10);

	glutMainLoop();
	return 0;
}
