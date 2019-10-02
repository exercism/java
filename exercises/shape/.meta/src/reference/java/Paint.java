
	public class Paint {

    /**
    * @pre: -
    * @post: return an array of type Drawable
    */
    public Drawable[] painting(){
            Drawable stunningPaint []= new Drawable[6];

            Drawable ovale= new Oval(50,50,400,400);
            stunningPaint [0]= ovale;

            Drawable rect= new Rectangle(114,123,323,56,140);
            stunningPaint [1]= rect;

            Drawable carre= new Square(24,24,323,24);
            stunningPaint [2]= carre;

            Drawable triangle= new Triangle(100, 250,200,300,160,100);
            stunningPaint [3]= triangle;

            Drawable equi = new Triangle_Equilateral(150,100,250);
            stunningPaint [4]= equi;


            return stunningPaint;
        }
	
		public static void main(String[] args) {

            Paint paint = new Paint();
            Drawable[] stunningPaint=  paint.painting();
            DrawWindows drawWindows;
            for (Drawable shape: stunningPaint){
                if(shape!=null){
                  drawWindows = new DrawWindows(shape);
                }
            }
		}
	}