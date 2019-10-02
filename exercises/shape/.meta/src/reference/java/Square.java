

	public class Square extends Rectangle{
		
		/**
		 * 
		 * @pre  x0 >= 0, y0 >= 0, x1 >= 0, y1 >= 0
		 * @post Create an instance of Square
		 *  (0) (x0,y0)........(x1,y1) (1)
		 *             .      .
		 *             .      .
		 *             .      .
		 *  (2) (x2,y2)........(x3,y3) (3)
		 */
		public Square(int x0, int y0, int x1, int y1) {
			super(x0, y0, x1, y1,x1-x0);
		}

		/**
		 * @pre  x0 >= 0, y0 >= 0, height >= 0
		 * @post Create an instance of Square
		 *  (0) (x0,y0)........(x1,y1) (1)
		 *             .      .
		 *             .      .
		 *             .      .
		 *  (2) (x2,y2)........(x3,y3) (3)
		 */
		public Square(int x0, int y0, int height) {
			super(x0, y0, x0+height, y0,height);
		}
	}