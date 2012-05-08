package vm3;

public interface Monitor {
	public void setFixed(boolean fixed);
	public void setHeight(int height);
	public void setWidth(int width);
	public void setFont(byte font);
	public void setColor(byte color);
	public void setFace(byte face);
	public void setTextFG(byte textfg);
	public void setTextBG(byte textbg);
	public void setScreenHeight(byte screenheight);
	public void setLineWidth(byte linewidth);
}
