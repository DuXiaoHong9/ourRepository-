package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


//@Entity
//@Table(name="STREET")
public class street implements Serializable {
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_street")
//	@SequenceGenerator(name="seq_street",sequenceName="house_street_id")
	private Short id;//街道id
//	private Short district_id;//区县id
//	@Column(name="NAME")
	private String name;//街道名称
//	@ManyToOne
//	@JoinColumn(name="DISTRICT_ID")
	private district dis;//区县
//	@OneToMany(mappedBy="street",cascade={CascadeType.ALL})
	private Set<house> houses = new HashSet<house>();
	
	public street(String name, district dis) {
		this.name = name;
		this.dis = dis;
	}
	public Set<house> getHouses() {
		return houses;
	}
	public void setHouses(Set<house> houses) {
		this.houses = houses;
	}
	public district getDis() {
		return dis;
	}
	public void setDis(district dis) {
		this.dis = dis;
	}
//	public street(Short id, Short district_id, String name, district dis) {
//		this.id = id;
//		this.district_id = district_id;
//		this.name = name;
//		this.dis = dis;
//	}
//	
//	
//	public Short getDistrict_id() {
//		return district_id;
//	}
//	public void setDistrict_id(Short district_id) {
//		this.district_id = district_id;
//	}
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
//	public street(Short id, Short district_id, String name) {
//		this.id = id;
//		this.district_id = district_id;
//		this.name = name;
//	}
	
	public street() {}
	public street(Short id, String name, district dis, Set<house> houses) {
		this.id = id;
		this.name = name;
		this.dis = dis;
		this.houses = houses;
	}
	
	public street(Short id) {
		this.id = id;
	}
	public street(Short id, String name, district dis) {
	this.id = id;
	this.name = name;
	this.dis = dis;
}
	
}
