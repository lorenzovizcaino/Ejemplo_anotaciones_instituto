package modelofk;
// Generated 21:08:45, 9 de mar. de 2023 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Modulo generated by hbm2java
 */
@Entity
@Table(name = "modulo", catalog = "instituto")
public class Modulo implements java.io.Serializable {

	private Integer idModulo;
	private String nombre;
	private Set<Profesor> profesors = new HashSet<Profesor>(0);

	public Modulo() {
	}

	public Modulo(String nombre) {
		this.nombre = nombre;
	}

	public Modulo(String nombre, Set<Profesor> profesors) {
		this.nombre = nombre;
		this.profesors = profesors;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idModulo", unique = true, nullable = false)
	public Integer getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "profesormodulo", catalog = "instituto", joinColumns = {
			@JoinColumn(name = "idModulo", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idProfesor", nullable = false, updatable = false) })
	public Set<Profesor> getProfesors() {
		return this.profesors;
	}

	public void setProfesors(Set<Profesor> profesors) {
		this.profesors = profesors;
	}

}
