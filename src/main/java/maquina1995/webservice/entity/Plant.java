package maquina1995.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Plant extends AbstractAuditable<Long> {

	@GeneratedValue(generator = "sequence",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence",
	        allocationSize = 1)
	@Id
	@EqualsAndHashCode.Exclude
	private Long id;
	private String name;
	private Boolean hibernates;
	private Float high;
}
