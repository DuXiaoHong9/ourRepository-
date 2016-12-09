package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


//@Entity
//@Table(name="TYPES")
public class types implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_types")
//	@SequenceGenerator(name="seq_types",sequenceName="house_types_id")
	private Short id;//类型id
//	@Column(name="NAME")
	private String name;//类型名称
//	@OneToMany(mappedBy="types",cascade={CascadeType.ALL})
	private Set<house> houses = new HashSet<house>();
	
	
	
	public Set<house> getHouses() {
		return houses;
	}
	public void setHouses(Set<house> houses) {
		this.houses = houses;
	}
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public types(Short id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public types(Short id, String name, Set<house> houses) {
		this.id = id;
		this.name = name;
		this.houses = houses;
	}
	
	public types(Short id) {
		this.id = id;
	}
	public types() {}
	
}
