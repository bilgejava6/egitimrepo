package aradonemodev.repository.entity;

import aradonemodev.utility.StaticValues;

import java.util.LinkedHashSet;
import java.util.Set;

public class Mudur extends Personel{
    private Set<Departman> sorumluOlduguDepartmanlar;

    public Mudur() {
        super();
        sorumluOlduguDepartmanlar = new LinkedHashSet<>();
    }

    public Mudur(String ad, String iseBaslamaTarihi, double maas) {
        sorumluOlduguDepartmanlar = new LinkedHashSet<>();
        this.setId(StaticValues.personlerIdOlustur());
    }

    public Mudur(String ad, String iseBaslamaTarihi) {
        sorumluOlduguDepartmanlar = new LinkedHashSet<>();
        this.setId(StaticValues.personlerIdOlustur());
        this.setAd(ad);
        this.setIseBaslamaTarihi(iseBaslamaTarihi);
    }

    public Set<Departman> getSorumluOlduguDepartmanlar() {
        return sorumluOlduguDepartmanlar;
    }
    public void setSorumluOlduguDepartmanlar(Set<Departman> sorumluOlduguDepartmanlar) {
        this.sorumluOlduguDepartmanlar = sorumluOlduguDepartmanlar;
    }

    @Override
    public String toString() {
        return "Mudur [sorumluOlduguDepartmanlar=" + sorumluOlduguDepartmanlar + ", toString()=" + super.toString()
                + "]";
    }
}
