
	public class Paint {

        /**
         * @pre: -
         * @post: return an array of type Drawable
         */
         public Drawable[] painting(){
            // To DO
         }

		 public static void main(String[] args) {

            Paint paint = new Paint();
            Drawable triangle= new Triangle(100, 250,200,300,160,100);
            DrawWindows drawWindows = new DrawWindows(triangle);
		 }
	}