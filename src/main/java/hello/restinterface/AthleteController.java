package hello.restinterface;

import org.gniza.biking.equipment.graphmodel.Athlete;
import org.gniza.biking.equipment.graphmodel.SourceSystemEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AthleteController {
    @RequestMapping("/rest/athlete")
    public Athlete athlete(@RequestParam String externalId, @RequestParam SourceSystemEnum sourceSystemEnum) {
        Athlete athlete = new Athlete();
        athlete.setExternalId(externalId);
        athlete.setSourceSystem(sourceSystemEnum);
        athlete.setFirstname("Benni");
        return athlete;
    }
}
