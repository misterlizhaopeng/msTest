package go.component;

import go.beans.Blue;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

@Configuration
@Import(value = {Blue.class,MySelector.class})
public class ComponentSelector {

}


class  MySelector implements ImportSelector{

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String [] cls={"go.beans.Dog","go.beans.Red"};
        return cls;
//        return new String[0];
    }
}