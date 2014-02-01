/*
 * MetabolismListener.java
 * 
 * Listen changes on Metabolism.
 * 27/01/2014 
 */


package model.eventListeners;


import java.util.EventListener;

import model.Metabolism;
import model.eventObject.MetabolismChangedEvent;


/**
 * MetabolismListener listen changes on Metabolism.
 * 
 * @author Yoan DUMAS
 * @version 1.0
 * @see Metabolism
 */
public interface MetabolismListener extends EventListener {

	
	public void metabolismChanged(MetabolismChangedEvent event);
}
