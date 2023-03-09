package modelofk;
// Generated 21:08:45, 9 de mar. de 2023 by Hibernate Tools 4.3.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Direccion generated by hbm2java
 */
@Entity
@Table(name = "direccion", catalog = "instituto")
public class Direccion implements java.io.Serializable {

	private Integer id;
	private Provincia provincia;
	private String calle;
	private Integer numero;
	private String poblacion;

	public Direccion() {
	}

	public Direccion(Provincia provincia) {
		this.provincia = provincia;
	}

	public Direccion(Provincia provincia, String calle, Integer numero, String poblacion) {
		this.provincia = provincia;
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProvincia", nullable = false)
	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Column(name = "calle")
	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Column(name = "numero")
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name = "poblacion")
	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

}
