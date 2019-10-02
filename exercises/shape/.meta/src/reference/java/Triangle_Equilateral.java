


    public class Triangle_Equilateral extends Triangle {
				
		/**
		 * @pre   x0 >=0 , y0 >=0, x1 >=0
		 * @post Create an instance of Triangle_Equilateral
         *       The coordinate x0, y0 and x1 allows to create a
         *       equilateral triangle parallel to abscissa axe x,
         *       if x1 > x0 the triangle is oriented to north  otherwise to south
		 */

		public Triangle_Equilateral(int x0, int y0, int x1){
			super(x0, y0,x1,y0,x0+(x1-x0)/2, y0 -(int)((x1-x0)*Math.sqrt(3)/2) ); // same than below but using super;
			/*
			//Same code than using supper but using the global variable instead, this is not recommended is always better the use of supper.
			// this has been added to better understand the initialisation of globals variables.
			int distance = (x1-x0);
			this.x0=x0;
			this.y0=y0;

			this.x1=x1;
			this.y1=y0;

			this.x2=x0+distance/2;
			this.y2= y0 -(int)(distance*Math.sqrt(3)/2); // more exact
			*/
		}
	}