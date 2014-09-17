package com.comfenalco.admin.entity.PU2;

import com.comfenalco.admin.entity.MaestroSubsidio;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-29T09:04:54")
@StaticMetamodel(MaestroSubsidio.class)
public class MaestroSubsidio_ { 

    public static volatile SingularAttribute<MaestroSubsidio, Integer> id;
    public static volatile SingularAttribute<MaestroSubsidio, Date> fechaAsignacionSubsidio;
    public static volatile SingularAttribute<MaestroSubsidio, String> identificacionAfiliado;
    public static volatile SingularAttribute<MaestroSubsidio, BigDecimal> valorSubsidio;
    public static volatile SingularAttribute<MaestroSubsidio, Date> fechaUltimoSubsidio;
    public static volatile SingularAttribute<MaestroSubsidio, String> tipoAfiliado;
    public static volatile SingularAttribute<MaestroSubsidio, String> nombreArchivoMaestro;
    public static volatile SingularAttribute<MaestroSubsidio, String> ciudadRecibioSubsidio;
    public static volatile SingularAttribute<MaestroSubsidio, String> identificacionBeneficiario;
    public static volatile SingularAttribute<MaestroSubsidio, String> dptoRecicbioSubsidio;
    public static volatile SingularAttribute<MaestroSubsidio, Date> fechaCreacion;
    public static volatile SingularAttribute<MaestroSubsidio, String> tipoSubsidio;
    public static volatile SingularAttribute<MaestroSubsidio, String> tipoBeneficiario;

}