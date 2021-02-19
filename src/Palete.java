import java.util.ArrayList;
import java.util.List;

public class Palete {

    int color_range [];


   public void setColor_range(ArrayList<Control> color){

       color_range = new int[color.size()];

       for (int i= 0; i < color.size(); i++){

           int medianColor = ( color.get(i).getMinVal() + color.get(i).getMaxVal() )  / 2 ;

           color_range[i] = medianColor;

       }

       System.out.println("Medium value:");

       for(int k=0; k < color_range.length; k++){
           System.out.println(color_range[k]);

       }
   }


}
