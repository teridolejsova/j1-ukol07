package cz.czechitas.ukol7.formbuilder;

/**
 * @author Filip Jirsák
 */
public interface WithInput<B> {
  FormBuilderWithContainer<B> add();

  FormBuilderWithContainer<B> add(Object constraints);
}
