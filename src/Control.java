public class Control {
    private  int startV;
    private int finalV;
    private int minVal;
    private int maxVal;


    Control(){
        startV = 0;
        finalV = 0;
        maxVal=0;


    }


    public void setFinalV(int finalV) {
        this.finalV = finalV;
    }

    public void setStartV(int startV) {
        this.startV = startV;
    }


    public int getFinalV() {
        return finalV;
    }

    public int getStartV() {
        return startV;
    }


    public int getMaxVal() {
        return maxVal;
    }

    public int getMinVal() {
        return minVal;
    }

    public void setMaxVal(int maxVal) {
        this.maxVal = maxVal;
    }

    public void setMinVal(int minVal) {
        this.minVal = minVal;
    }
}
