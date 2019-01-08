package fr.formation.choco.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe qui représente un type de chocolat qu'il est possible de commander
 * dans la boutique.
 */
@Entity
@Table(name="chocotype")
public class ChocoType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String label;

	@Column
	private String value;
	
	@Column
	private String url;
	
	@ManyToOne
	@JoinColumn(name="origin_id", referencedColumnName="id")
	private ChocoOrigin origin;

	public ChocoOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(ChocoOrigin origin) {
		this.origin = origin;
	}

	public ChocoType() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ChocoType(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public ChocoType(Integer id, String label, String value) {
		this(label, value);
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
