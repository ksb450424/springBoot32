package springrest.exam.controller;

import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.exam.domain.ComicActor;
import springrest.exam.domain.ComicActorModel;

import java.util.List;

@RestController
public class ComicActorController {

    /**
     * "둘리", "또치", "도우너" 를 가지고 각각 ComicActorModel 객체를 생성한 다음
     * 생성된 ComicActorModel 객체에 자세한 정보를 제공하는 URL(각각 아래 메서드에 대한
     * URL) 정보를 추가한 다음 CollectionModel 객체에 담아 응답한다.
     *
     * @return
     */
    @GetMapping("/all")
    public List<ComicActorModel> allActor() {
        ComicActorModel doolyModel = ComicActorModel.builder().name("둘리").build();
        doolyModel.add(Link.of("http://localhost:8080/dooly"));

        ComicActorModel ddochiModel = ComicActorModel.builder().name(getDdochi().getBody().getName()).build();
        ddochiModel.add(Link.of("http://localhost:8080/ddochi").withRel("actorLink"));

        ComicActorModel daunerModel = ComicActorModel.builder().name(getDauner().getBody().getName()).build();
        daunerModel.add(Link.of("http://localhost:8080/dauner").withRel("actorLink"));

        List<ComicActorModel> actorList = List.of(doolyModel, ddochiModel, daunerModel);
        return actorList;
    }

    @GetMapping("/dooly")
    public ResponseEntity<ComicActor> getDooly() {
        ComicActor dooly = ComicActor.builder()
                .name("둘리")
                .addr("쌍문동")
                .image("dooly.jpg")
                .build();
        return ResponseEntity.ok().body(dooly);
    }

    @GetMapping("/ddochi")
    public ResponseEntity<ComicActor> getDdochi() {
        ComicActor ddochi = ComicActor.builder()
                .name("또치")
                .addr("아프리카")
                .image("ddochi.jpg")
                .build();
        return ResponseEntity.ok().body(ddochi);
    }

    @GetMapping("/dauner")
    public ResponseEntity<ComicActor> getDauner() {

        ComicActor dauner = ComicActor.builder()
                .name("도우너")
                .addr("깐따삐아")
                .image("dauner.png")
                .build();
        return ResponseEntity.ok().body(dauner);
    }

}
