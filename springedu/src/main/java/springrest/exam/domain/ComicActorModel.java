package springrest.exam.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Builder
public class ComicActorModel extends RepresentationModel<ComicActorModel>{

    private String name;

}
