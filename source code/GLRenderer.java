package org.yourorghere;

import java.awt.event.KeyEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class GLRenderer implements GLEventListener {
float Angle = 0;
//    void Key_Pressed(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    //class vector untuk memudah vektor-isasi
    class vector {

        float x;
        float y;
        float z;

        public vector(float startX, float startY, float startZ) {
            x = startX;
            y = startY;
            z = startZ;
        }

        void vectorRotation(vector reference, float angle) {
            vector temp = reference;
            float magnitude = (float) Math.sqrt(Math.pow(temp.x,
                    2) + Math.pow(temp.y, 2) + Math.pow(temp.z, 2));
            temp.x = temp.x / magnitude;
            temp.y
                    = temp.y / magnitude;
            temp.z = temp.z / magnitude;
            float dot_product
                    = (x * temp.x) + (y * temp.y) + (z * temp.z);
            float cross_product_x = (y * temp.z) - (temp.z * z);
            float cross_product_y = -((x * temp.z) - (z * temp.x));
            float cross_product_z = (x * temp.y) - (y * temp.x);
            float last_factor_rodrigues = (float) (1
                    - Math.cos(Math.toRadians(angle % 360)));

            x = (float) ((x * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_x * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * x));

            y = (float) ((this.y * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_y * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * y));

            z = (float) ((z * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_z * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * z));

        }

    }

    vector depanBelakang = new vector(0f, 0f, -1f);//deklarasi awal vektor untuk maju & mundur
    vector samping = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan & kiri
    vector vertikal = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun

    float Cx = 0, Cy = 2.5f, Cz = 0;
    float Lx = 0, Ly = 2.5f, Lz = -20f;

    float angle_depanBelakang = 0f;
    float angle_depanBelakang2 = 0f;

    float angle_samping = 0f;
    float angle_samping2 = 0f;

    float angle_vertikal = 0f;
    float angle_vertikal2 = 0f;

    float silinderAngle = 0f;
    
    float silinderAngley = 0f;
    float silinderAnglez = 0f;
    boolean ori = true, silinder = false, kamera = false, silinder1 = false,
            silindery = false, silindery1 = false, silinderz = false,
            kamerax = false, kameray1 = false, kameraz = false, kameraz1 = false;

    /*
 ini adalah metod untuk melakukan pergerakan.
 magnitude adalah besarnya gerakan sedangkan direction
digunakan untuk menentukan arah.
 gunakan -1 untuk arah berlawanan dengan vektor awal
     */

    private void vectorMovement(vector toMove, float magnitude,
            float direction) {
        float speedX = toMove.x * magnitude * direction;
        float speedY = toMove.y * magnitude * direction;
        float speedZ = toMove.z * magnitude * direction;

        Cx += speedX;
        Cy += speedY;
        Cz += speedZ;

        Lx += speedX;
        Ly += speedY;
        Lz += speedZ;
    }

    private void cameraRotation(vector reference, double angle) {
        float M = (float) (Math.sqrt(Math.pow(reference.x, 2)
                + Math.pow(reference.y, 2) + Math.pow(reference.z, 2)));//magnitud

        float Up_x1 = reference.x / M; //melakukan
        float Up_y1 = reference.y / M; //normalisasi
        float Up_z1 = reference.z / M; //vektor patokan

        float VLx = Lx - Cx;
        float VLy = Ly - Cy;
        float VLz = Lz
                - Cz;
        float dot_product = (VLx * Up_x1) + (VLy * Up_y1) + (VLz * Up_z1);
        float cross_product_x = (Up_y1 * VLz) - (VLy * Up_z1);
        float cross_product_y = -((Up_x1 * VLz) - (Up_z1 * VLx));
        float cross_product_z = (Up_x1 * VLy) - (Up_y1 * VLx);

        float last_factor_rodriques = (float) (1
                - Math.cos(Math.toRadians(angle % 360)));

        float Lx1 = (float) ((VLx * Math.cos(Math.toRadians(angle % 360)))
                + (cross_product_x * Math.sin(Math.toRadians(angle % 360)))
                + (dot_product * last_factor_rodriques * VLx));

        float Ly1 = (float) ((VLy * Math.cos(Math.toRadians(angle % 360)))
                + (cross_product_y * Math.sin(Math.toRadians(angle % 360)))
                + (dot_product * last_factor_rodriques * VLy));

        float Lz1 = (float) ((VLz * Math.cos(Math.toRadians(angle % 360)))
                + (cross_product_z * Math.sin(Math.toRadians(angle % 360)))
                + (dot_product * last_factor_rodriques * VLz));

        Lx = Lx1 + Cx;
        Ly = Ly1 + Cy;
        Lz = Lz1 + Cz;
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: "
                + gl.getClass().getName());
        // Enable VSync
        gl.setSwapInterval(1);
        float ambient[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float position[] = {1.0f, 1.0f, 1.0f, 0.0f};
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position, 0);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClearColor(0f, 0f, 1.0f, 1.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
        //gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y,
            int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        Angle += -10;
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT
                | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        // Move the "drawing cursor" around
        glu.gluLookAt(Cx, Cy, Cz,
                Lx, Ly, Lz,
                vertikal.x, vertikal.y, vertikal.z);
 
        gl.glPushMatrix();
        gl.glTranslatef(0f, 1f, -10f);
        gl.glRotatef(silinderAngle, 1f, 0, 0);
        gl.glRotatef(-90, 0, 0f, 1);
       // gl.glRotatef(90, 0, 1f, 0);
       // gl.glRotatef(silinderAnglez, 0, 0, 1f);
        Objek.Persegi(gl);
        gl.glPopMatrix();
//        gl.glPushMatrix();
//        gl.glTranslatef(-1f, 3.4f, -5f);
//        gl.glRotatef(Angle, 0f, 1, 0);
//        Objek.balingBaling(gl);
//        gl.glPopMatrix();
//        gl.glPushMatrix();
//        gl.glTranslatef(-1f, 3.4f, -15f);
//         gl.glRotatef(90, 0f, 1, 0);
//        gl.glRotatef(Angle, 0f, 1, 0);
//        Objek.balingBaling(gl);
//        gl.glPopMatrix();
        
          gl.glPushMatrix();
        gl.glTranslatef(4f, 1.2f, -13f);
        
        //gl.glRotatef(90, 1f, 0, 0);
        gl.glRotatef(Angle, 0f, 1, 0);
        Objek.balingBaling(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
         gl.glTranslatef(4f, 1.2f, -13f);
         gl.glRotatef(90, 0f, 1, 0);
         //gl.glRotatef(90, 0f, 0, 1);
        gl.glRotatef(Angle, 0f, 1, 0);
        Objek.balingBaling(gl);
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
//        Objek.Sayap(gl);
//        gl.glTranslatef(0f, 0f, -10f);
//        //gl.glRotatef(0, 0f, 1, 0);
//        gl.glPopMatrix();
        
         
          gl.glPushMatrix();
        gl.glTranslatef(4f, 1.2f, -5f);
        
       // gl.glRotatef(90, 1f, 0, 0);
        gl.glRotatef(Angle, 0f, 1, 0);
        Objek.balingBaling(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
          gl.glTranslatef(4f, 1.2f, -5f);
         gl.glRotatef(90, 0f, 1, 0);
         //gl.glRotatef(90, 0f, 0, 1);
        gl.glRotatef(Angle, 0f, 1, 0);
        Objek.balingBaling(gl);
        gl.glPopMatrix();
        
//        gl.glPushMatrix();
//           gl.glTranslatef(-0.2f, 3.1f, -9f);
//          gl.glRotatef(90, 0f, 0, 1);
//        Objek.Sayap(gl);
//       
//        //gl.glRotatef(0, 0f, 1, 0);
//        gl.glPopMatrix();
//        
//          gl.glPushMatrix();
//           gl.glTranslatef(-0.2f, 1.5f, -9f);
//          gl.glRotatef(90, 0f, 0, 1);
//           gl.glRotatef(-180, 0f, 1, 0);
//        Objek.Sayap(gl);
//       
//        //gl.glRotatef(0, 0f, 1, 0);
//        gl.glPopMatrix();
        
        
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    void Key_Pressed(int keyCode) {
//huruf W
        if (keyCode == KeyEvent.VK_W) {
            vectorMovement(depanBelakang, 2f, 1f);
        } //huruf S
        else if (keyCode == KeyEvent.VK_S) {
            vectorMovement(depanBelakang, 2f, -1f);
        } //huruf A
        else if (keyCode == KeyEvent.VK_A) {
            vectorMovement(samping, 2f, 1f);
        } //huruf D
        else if (keyCode == KeyEvent.VK_D) {
            vectorMovement(samping, 2f, -1f);
        } //panah atas
        else if (keyCode == KeyEvent.VK_UP) {
            vectorMovement(vertikal, 2f, 1f);
        } //panah bawah
        else if (keyCode == KeyEvent.VK_DOWN) {
            vectorMovement(vertikal, 2f, -1f);
        } //tombol V z-
        
    }
}
