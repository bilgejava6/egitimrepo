package aradonemodev.repository.entity;

import aradonemodev.utility.StaticValues;

import java.util.LinkedHashSet;
import java.util.Set;

public class GenelMudur extends Mudur{
    private Set<Mudur> bagliMudurler;

    public GenelMudur() {
        super();
        bagliMudurler = new LinkedHashSet<>();
    }
    public GenelMudur(String ad, String iseBaslamaTarihi) {
        this.setId(StaticValues.personlerIdOlustur());
        bagliMudurler = new LinkedHashSet<>();
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }
}
