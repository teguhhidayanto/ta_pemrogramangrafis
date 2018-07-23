package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Objek {

    static void Persegi(GL gl) {
        float amb[] = {0, 0.5f, 0, 1};
        float diff[] = {0, 0.5f, 0, 1};
        float spec[] = {0, 0.5f, 0, 1};
        float shine = 0;
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(0, 0, 2);
        gl.glVertex3f(2, 0, 2);
        gl.glVertex3f(2, 0, 0);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(0, 4, 0);
        gl.glVertex3f(2, 4, 0);
        gl.glVertex3f(2, 0, 0);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 4, 0);
        gl.glVertex3f(2, 4, 0);
        gl.glVertex3f(2, 4, 2);
        gl.glVertex3f(0, 4, 2);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 4, 2);
        gl.glVertex3f(2, 4, 2);
        gl.glVertex3f(2, 0, 2);
        gl.glVertex3f(0, 0, 2);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(2, 4, 2);
        gl.glVertex3f(2, 4, 0);
        gl.glVertex3f(2, 0, 0);
        gl.glVertex3f(2, 0, 2);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 4, 2);
        gl.glVertex3f(0, 4, 0);
        gl.glVertex3f(0, 0, 0);
        gl.glVertex3f(0, 0, 2);
        gl.glEnd();
        
        //sayap 
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 4, 0);
        gl.glVertex3f(0, 5, 0);
        gl.glVertex3f(0, 5, -2);
        gl.glVertex3f(0, 4, 0);
        gl.glEnd();
        
         gl.glBegin(GL.GL_POLYGON);
        gl.glVertex3f(0, 4, 2);
        gl.glVertex3f(0, 5, 2);
        gl.glVertex3f(0, 5, 4);
        gl.glVertex3f(0, 4, 2);
        gl.glEnd();
        
        
      
        
    }
  
//    static void Sayap(GL gl)
// {
//    float amb[] = {1, 0.5f, 0, 1};
//        float diff[] = {1, 0.5f, 0, 1};
//        float spec[] = {1, 0.5f, 0, 1};
//        float shine = 0;
//        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
//        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diff, 0);
//        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, spec, 0);
//        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
// gl.glBegin(GL.GL_POLYGON);
// gl.glVertex3f(-0.5f,0.0f,0.0f);
// gl.glVertex3f(-0.5f,0.3f,0.0f);
// gl.glVertex3f(0.5f,0.0f,0.0f);
// gl.glEnd();
// 
// gl.glBegin(GL.GL_POLYGON);
// gl.glVertex3f(-0.5f,0.0f,0.3f);
// gl.glVertex3f(-0.5f,0.3f,0.3f);
// gl.glVertex3f(0.5f,0.0f,0.3f); 
// gl.glEnd();
// 
// gl.glBegin(GL.GL_POLYGON);
// gl.glVertex3f(-0.5f,0.3f,0.0f);
// gl.glVertex3f(0.5f,0.0f,0.0f);
// 
// gl.glVertex3f(0.5f,0.0f,0.3f);
// gl.glVertex3f(-0.5f,0.3f,0.3f);
// 
//  gl.glBegin(GL.GL_POLYGON);
// gl.glVertex3f(-0.5f,0.3f,0.0f);
// gl.glVertex3f(-0.5f,0.3f,0.3f);
// gl.glVertex3f(-0.5f,0.0f,0.3f);
// gl.glVertex3f(-0.5f,0.0f,0.0f);
// gl.glEnd();
// 
//}
      static void balingBaling(GL gl)
{   
      float amb[] = {1, 0.5f, 1, 1};
        float diff[] = {1, 0.5f,1, 1};
        float spec[] = {1, 0.5f, 1, 1};
        float shine = 0;
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
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
    

