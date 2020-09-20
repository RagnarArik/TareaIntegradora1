import java.util.Scanner;
public class TareaIntegradora1{
	public static final int strucWork=1300000;
	public static final int finalWork=2600000;
	public static final int paint=980000;
public static Scanner sc = new Scanner(System.in);
//Main 
 public static void main(String args[]) {
	String vivU=live();
	int cantM=materialQ();
	String[]arrayMQA=arrayMQ(cantM);
	double[]arrayHCP=arrayHC(cantM, arrayMQA);
	double []arrayFCP=arrayFC(cantM);
	double []arrayFBP=arrayFB(cantM);
 String [] arrayOB=arrayO(cantM);
	double contP=arrayComp(cantM, arrayHCP , arrayFBP,arrayFCP, arrayMQA);
	double valDom=dom(contP, vivU);
	double fainalPrec=fainal(contP, valDom);
	}

/**
*Name: live
*this method gets the location of the house <br>
*<b> post: </b> the location of the hause was obtained
*@return String vivU is the ubication of the hause
*/
public static String live (){
	String vivU="";
	System.out.println("¿la vivienda se encuentra en el norte, centro o sur de la ciudad?");
	vivU=sc.nextLine();
	return vivU;
}
/**
*Name: materialQ
*this method gets the amount of materials <br>
*<b> post: </b> the amount of materials was obtained
*@return int cantM is the amount of materials
*/

public static int materialQ (){
	System.out.println("¿cuantos materiales ingresará?");
	int cantM=sc.nextInt();
	sc.nextLine();
	return cantM;
	}


/**
*Name: arrayMQ
*this method gets the name of the materials
*<b> post: </b> the names of materials was obtained
*@param int cantM quantity of materials
*@return String arrayMQA are the names of materials
*/
public static String [] arrayMQ(int cantM){
 String  [] arrayMQA = new String [cantM];
  for (int i=0; i<arrayMQA.length; i++){
		System.out.println("ingrese el nombre del material "+(i+1));
	arrayMQA[i]=sc.nextLine();
	}
return arrayMQA;
}


/**
*Name: arrayHC
*This method gets the price of the materials in HomeCenter
*<b> post: </b> the price of the material in HomeCenter was obtained
*@param int cantM quantity of materials
*@param String arrayMQA name of the materials
*@return double arrayHCP are the prices of the materials in HomeCenter
*/
public static double [] arrayHC(int cantM, String [] arrayMQA){
 double[]arrayHCP = new double [cantM];
	 for (int i=0; i<arrayHCP.length; i++){
		System.out.println("ingrese el precio del material "+arrayMQA[i]+" en HomeCenter");
	arrayHCP[i]=sc.nextInt();
	}
	return arrayHCP;
} 
/**
*Name: arrayFC
*This method gets the price of the materials in Ferretería del centro
*<b> post: </b> the price of the materials in Ferreteria del centro was obtained
*@param cantM quantity of materials
*@return double arrayFCP are the prices of the material in Ferreteria del centro
*/
public static double [] arrayFC(int cantM){
 double[]arrayFCP = new double [cantM];
	 for (int i=0; i<arrayFCP.length; i++){
		System.out.println("ingrese el precio del material "+(i+1)+" en la ferretería del centro");
	arrayFCP[i]=sc.nextInt();
	sc.nextLine();
	}
	return arrayFCP;
}
/**
*Name: arrayFC
*This method gets the price of the materials in Ferretería de barrio
*<b> post: </b> the price of the materials in Ferreteria de barrio was obtained
*@param cantM quantity of materials
*@return double arrayFCP are the prices of the material in Ferreteria de barrio
*/
public static double [] arrayFB(int cantM){
 double[]arrayFBP = new double [cantM];
	 for (int i=0; i<arrayFBP.length; i++){
		System.out.println("ingrese el precio del material "+(i+1)+" en Ferretería de Barrio");
	arrayFBP[i]=sc.nextInt();
	sc.nextLine();
	}
	return arrayFBP;
}
/**
*Name: arrayO
*This method gets what type is each one of the materials
*<b> post: </b> the type of the materials was obtained
*@param cantM quantity of materials
*@return double arrayFOB are the tipe of materials
*/
public static String [] arrayO(int cantM){
	String [] arrayOB=new String[cantM];
	String [] arrayNOB=new String[arrayOB.length];
	String [] arrayBOB=new String[arrayOB.length];
	String [] arrayPOB=new String[arrayOB.length];
	int ac=0;
	for (int i=0; i<arrayOB.length; i++){
	System.out.println("Ingrese de qué tipo de obra es el materia"+(i+1));
	arrayOB[i]=sc.nextLine();
	if (arrayOB[i]=="obra negra"){
		arrayNOB[ac]=arrayOB[i];
	}
	if (arrayOB[i]=="obra blanca"){
		arrayBOB[ac]=arrayOB[i];
	}
	if (arrayOB[i]=="pintura"){
		arrayPOB[ac]=arrayOB[i];
    }	
	}
	return arrayOB;
}

/**
*Name: arrayComp
*This method gets the best price of the materials in each one of the ironmongery
*<b> post: </b> the best price was obtained
*@param int cantM quantity of the materials
*@param double arrayHCP are the prices of the materials in HomeCenter
*@param double arrayFCP are the prices of the materials in Ferretería del centro
*@param double arrayFBP are the prices of the materials in Ferretería de barrio
*@param String arrayMQA are the names of the materials
*@return double contP is the best prices of the materials
*/
public static double arrayComp (int cantM, double[]arrayHCP , double [] arrayFBP,double [] arrayFCP, String [] arrayMQA){
	double contP=0;
for (int i=0; i<cantM; i++){
	if (arrayHCP[i]<=arrayFBP[i] && arrayHCP[i]<=arrayFCP[i]){
		System.out.println("la tienda con mejor precio para el producto "+arrayMQA[i]+" es HomeCenter= "+arrayHCP[i]);
	contP=contP+arrayHCP[i];
	}
	if (arrayFCP[i]<=arrayHCP[i] && arrayFCP[i]<=arrayFBP[i]){
		System.out.println("la tienda con mejor precio para el producto "+arrayMQA[i]+" es Ferretería del centro= "+arrayFCP[i]);
    contP=contP+arrayFCP[i];
	}
	if (arrayFBP[i]<=arrayHCP[i] && arrayFBP[i]<=arrayFCP[i]){
	    System.out.println("la tienda con mejor precio para el producto "+arrayMQA[i]+" es Ferretería de barrio= "+arrayFBP[i]);
    contP=contP+arrayFBP[i];
}
}
return contP;	
}
/**
*Name: dom
*This method gets the delivery value
*<b> post: </b> the price of the delivery value was obtained
*@param double contP is the best price of the materials
*@param String vivU is the location of the hause
*@return duble valDom is the price of the delivery value
*/
public static double dom (double contP, String vivU){
double valDom=0;
if (contP<80000){
	if (vivU.equals ("norte")){
	valDom=120000;
	}
	if (vivU.equals ("centro")){
		valDom=50000;
	}
	if (vivU.equals ("sur")){
		valDom=120000;
	}
}
if  (contP<300000){
		if (vivU.equals ("norte")){
	valDom=28000;
	}
	if (vivU.equals ("centro")){
		valDom=0;
	}
	if (vivU.equals ("sur")){
		valDom=55000;
	}
}
if (contP>800000){
		if (vivU.equals ("norte")){
	valDom=0;
	}
	if (vivU.equals ("centro")){
		valDom=0;
	}
	if (vivU.equals("sur")){
		valDom=0;
	}
}
return valDom;
}
/**
*Name: fainal
*This method gets and print the final price
*<b> post: </b> print the final price
*@param double contP the best price of the materials
*@param double valDom price of the delivery
*@return double fainalPrec is the final price
*/
public static double fainal (double contP, double valDom){
	double fainalPrec=contP+valDom+strucWork+finalWork+paint;
	System.out.println("según las recomendaiones ya dadas más el valor del domicilio el total a pagar seía: "+fainalPrec);
return fainalPrec;
}
}

