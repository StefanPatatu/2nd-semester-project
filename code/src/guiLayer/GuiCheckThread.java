package guiLayer;

import java.util.Random;

import controlLayer.CtrCheckConnection;

import java.util.*;

public class GuiCheckThread extends Thread
{   GuiMain gm = GuiMain.getInstance();
	public void run()
	{	CtrCheckConnection ccc= new CtrCheckConnection();
		String result="";
		//int i=1;
		while(true)
		{
			try {
				GuiCheckThread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ccc.isValidd())
		{
			result="Connected to database";
		}
			else
			{
				result="Not connected to database";
			}
		
			gm.setTitle("Main: "+result);
		//	gm.lblcheck.setText(result);
			
			
		}
	}
	
}