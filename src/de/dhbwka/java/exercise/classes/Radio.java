package de.dhbwka.java.exercise.classes;

public class Radio {
	
	private boolean on = true;
	private int volume = 1;
	private double frequency = 99.9;
	
	public Radio(){}
	
	public Radio(boolean on, int volume, double frequency){
		this.on = on;
		this.volume = volume;
		this.frequency = frequency;
	}
	
	public void incVolume(){
		if(volume<10)
			volume++;
	}
	
	public void decVolume(){
		if(volume > 0)
			volume--;
	}
	
	public void turnOn(){
		on = true;
	}
	
	public void turnOff(){
		on = false;
	}
	
	public void setFrequency(double frequency){
		if(frequency>=85 && frequency<=110)
			this.frequency = frequency;
	}
	
	public String toString(){
		String zustand="";
		if(on){
			zustand+= "Radio an; ";
		}else{
			zustand+= "Radio aus; ";
		}
		return zustand+= "Lautstärke "+volume+"; Frequenz "+frequency+" MHz";
	}
}
