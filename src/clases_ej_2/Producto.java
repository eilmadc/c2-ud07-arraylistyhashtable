/**
 * 
 */
package clases_ej_2;

/**
 * @author elena-01
 *
 */
public class Producto {
	double posX;
	double precioBruto;
	double IVA;
	double precioTotal;
	/**
	 * @param posX
	 * @param precioBruto
	 * @param iVA
	 * @param numCarrito
	 */
	public Producto(double posX, double precioBruto, double iVA) {
		super();
		this.posX = posX;
		this.precioBruto = precioBruto;
		IVA = iVA;
		this.precioTotal = precioBruto +precioBruto * IVA;
	}
}
