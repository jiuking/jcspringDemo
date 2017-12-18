package test.bean;

import lombok.Getter;
import lombok.Setter;

public class AuditUser {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String password;

    @Override
    public int hashCode() {
        System.out.println(this.getId().hashCode());
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AuditUser) {
            AuditUser auditUser = (AuditUser) obj;
            return id.equals(auditUser.getId());
        }
        return super.equals(obj);
    }
}
