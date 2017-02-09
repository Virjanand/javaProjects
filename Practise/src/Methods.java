
public class Methods {
	
	int numberOfDoors = 5;
	float height = 0.5f;
	
	Methods(int i){
		numberOfDoors = i;
	}
	
	Methods(){
		
	}
	
	Methods(float h){
		height = h;
	}
	
	public String validateHeader() {
		
		System.out.println("Header links validated " + numberOfDoors);
		
		
		return "Pass";
	}

}
