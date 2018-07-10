package org.yourorghere;
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
public class Objek {



 float BODY_LENGTH=5f;
 float BODY_RADIUS=2.0f;
 int SLICES=30;
 int STACKS=30;
 GLU glu=new GLU();
 GLUquadric q=glu.gluNewQuadric();

 glu.gluCylinder(q, BODY_RADIUS, BODY_RADIUS,
BODY_LENGTH, SLICES, STACKS);
 glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
 gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
 glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS);
 }

static void Sayap(GL gl)
 {
 gl.glBegin(GL.GL_POLYGON);
 gl.glVertex3f(-0.5f,0.0f,0.0f);
 gl.glVertex3f(-0.5f,0.3f,0.0f);
 gl.glVertex3f(0.5f,0.0f,0.0f);
 gl.glEnd();
 
 gl.glBegin(GL.GL_POLYGON);
 gl.glVertex3f(-0.5f,0.0f,0.3f);
 gl.glVertex3f(-0.5f,0.3f,0.3f);
 gl.glVertex3f(0.5f,0.0f,0.3f); 
 gl.glEnd();
 
 gl.glBegin(GL.GL_POLYGON);
 gl.glVertex3f(-0.5f,0.3f,0.0f);
 gl.glVertex3f(0.5f,0.0f,0.0f);
 
 gl.glVertex3f(0.5f,0.0f,0.3f);
 gl.glVertex3f(-0.5f,0.3f,0.3f);
 
  gl.glBegin(GL.GL_POLYGON);
 gl.glVertex3f(-0.5f,0.3f,0.0f);
 gl.glVertex3f(-0.5f,0.3f,0.3f);
 gl.glVertex3f(-0.5f,0.0f,0.3f);
 gl.glVertex3f(-0.5f,0.0f,0.0f);
 gl.glEnd();

 static void balingBaling(GL gl)
{
 
    
  gl.glBegin(GL.GL_TRIANGLES);
  gl.glVertex3f(0, 0, 0);
  gl.glVertex3f(1, 0, 0.5f);
  gl.glVertex3f(1, 0, -0.5f);
  gl.glVertex3f(0, 0, 0);
  gl.glVertex3f(-1, 0, 0.5f);
  gl.glVertex3f(-1, 0, -0.5f);
  gl.glEnd();
}
  
}
