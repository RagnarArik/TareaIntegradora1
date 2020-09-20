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

//método para saber dónde vive el qcho
public static String live (){
	String vivU="";
	System.out.println("¿la vivienda se encuentra en el norte, centro o sur de la ciudad?");
	vivU=sc.nextLine();
	return vivU;
}
//metodo para saber cuantos materiales se ingresarán

public static int materialQ (){
	System.out.println("¿cuantos materiales ingresará?");
	int cantM=sc.nextInt();
	sc.nextLine();
	return cantM;
	}


//método para ingresar el nombre de los materiales :c
public static String [] arrayMQ(int cantM){
 String  [] arrayMQA = new String [cantM];
  for (int i=0; i<arrayMQA.length; i++){
		System.out.println("ingrese el nombre del material "+(i+1));
	arrayMQA[i]=sc.nextLine();
	}
return arrayMQA;
}


//metodo para ingresar el valor de los materiales en HomeCenter
public static double [] arrayHC(int cantM, String [] arrayMQA){
 double[]arrayHCP = new double [cantM];
	 for (int i=0; i<arrayHCP.length; i++){
		System.out.println("ingrese el precio del material "+arrayMQA[i]+" en HomeCenter");
	arrayHCP[i]=sc.nextInt();
	}
	return arrayHCP;
} 
//método para ingresar el valor de los materiales en Ferreteria del centro
public static double [] arrayFC(int cantM){
 double[]arrayFCP = new double [cantM];
	 for (int i=0; i<arrayFCP.length; i++){
		System.out.println("ingrese el precio del material "+(i+1)+" en la ferretería del centro");
	arrayFCP[i]=sc.nextInt();
	sc.nextLine();
	}
	return arrayFCP;
}
//Método para ingresar el valor de los materiales en ferretería de barrio
public static double [] arrayFB(int cantM){
 double[]arrayFBP = new double [cantM];
	 for (int i=0; i<arrayFBP.length; i++){
		System.out.println("ingrese el precio del material "+(i+1)+" en Ferretería de Barrio");
	arrayFBP[i]=sc.nextInt();
	sc.nextLine();
	}
	return arrayFBP;
}
/**¿Será obra negra, obra blanca o pintura? :o
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

//método para comparar los precios
public static double arrayComp (int cantM, double[]arrayHCP , double [] arrayFBP,double [] arrayFCP, String [] arrayMQA){
	double contP=0;
for (int i=0; i<cantM; i++){
	if (arrayHCP[i]<=arrayFBP[i] && arrayHCP[i]<=arrayFCP[i]){
		System.out.println("la tienda con mejor precio para el producto "+arrayMQA[i]+" es HomeCenter= "+arrayHCP[i]);
	contP=contP+arrayHCP[i];
	}
	if (arrayFCP[i]<=arrayHCP[i] && arrayFCP[i]<=arrayFBP[i]){
		System.out.println("la tienda con mejor precio para el producto "+arrayMQA[i]+" es HomeCenter= "+arrayFCP[i]);
    contP=contP+arrayFCP[i];
	}
	if (arrayFBP[i]<=arrayHCP[i] && arrayFBP[i]<=arrayFCP[i]){
	    System.out.println("la tienda con mejor precio para el producto "+arrayMQA[i]+" es HomeCenter= "+arrayFBP[i]);
    contP=contP+arrayFBP[i];
}
}
return contP;	
}
//metodo para sumar domicilio
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
//metodo recomendaciones y precio final
public static double fainal (double contP, double valDom){
	double fainalPrec=contP+valDom;
	System.out.println("según las recomendaiones ya dadas más el valor del domicilio el total a pagar seía: "+fainalPrec);
return fainalPrec;
}
}

