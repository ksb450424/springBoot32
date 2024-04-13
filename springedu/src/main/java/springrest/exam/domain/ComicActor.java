package springrest.exam.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ComicActor {

    private String name;
    private String addr;
    private String image;

}
