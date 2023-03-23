/**
 * 
 */
package clases_ej_4;

/**
 * @author elena-01
 *
 */
public class Producto {
	double posX;
	double precioBruto;
	double IVA;
	double precioTotal;
	int stock;
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
	
	public Producto(double precioBruto, int cantidad) {
		super();
		this.precioBruto = precioBruto;
		this.precioTotal = precioBruto +precioBruto * IVA;
		this.stock = cantidad;
	}

	
	//-------Getters y Setters --------------
	/**
	 * @return the posX
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}

	/**
	 * @return the precioBruto
	 */
	public double getPrecioBruto() {
		return precioBruto;
	}

	/**
	 * @param precioBruto the precioBruto to set
	 */
	public void setPrecioBruto(double precioBruto) {
		this.precioBruto = precioBruto;
	}

	/**
	 * @return the iVA
	 */
	public double getIVA() {
		return IVA;
	}

	/**
	 * @param iVA the iVA to set
	 */
	public void setIVA(double iVA) {
		IVA = iVA;
	}

	/**
	 * @return the precioTotal
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
}
