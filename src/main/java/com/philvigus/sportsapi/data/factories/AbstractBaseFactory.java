package com.philvigus.sportsapi.data.factories;

import com.github.javafaker.Faker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.beanutils.BeanUtils.setProperty;

public abstract class AbstractBaseFactory<T> {
  protected final Faker faker;

  protected final Class<T> clazz;

  protected final JpaRepository<T, Long> repository;

  public AbstractBaseFactory(final Class<T> clazz, JpaRepository<T, Long> repository) {
    faker = new Faker();

    this.clazz = clazz;
    this.repository = repository;
  }

  public T create(final Map<String, Object> customAttributes) {
    final T entity = getEntityWithAttributesSet(customAttributes);

    return repository.save(entity);
  }

  public T create() throws FactoryException {
    return create(new HashMap<>());
  }

  public T make(final Map<String, Object> customAttributes) throws FactoryException {
    return getEntityWithAttributesSet(customAttributes);
  }

  public T make() throws FactoryException {
    return make(new HashMap<>());
  }

  protected T getEntityWithAttributesSet(final Map<String, Object> customAttributes)
      throws FactoryException {
    final T entity;

    try {
      entity = clazz.getDeclaredConstructor().newInstance();
    } catch (InstantiationException
        | IllegalAccessException
        | IllegalArgumentException
        | InvocationTargetException
        | NoSuchMethodException e) {
      throw new FactoryException(String.format("Unable to create entity of type %s", clazz), e);
    }

    getCombinedAttributes(customAttributes)
        .forEach(
            (name, value) -> {
              try {
                setProperty(entity, name, value);
              } catch (IllegalAccessException | InvocationTargetException e) {
                throw new FactoryException(
                    String.format(
                        "Unable to set property %s to %s on entity of type %s", name, value, clazz),
                    e);
              }
            });

    return entity;
  }

  protected Map<String, Object> getCombinedAttributes(final Map<String, Object> customAttributes) {
    final Map<String, Object> defaultAttributes = defaultAttributes();

    defaultAttributes.putAll(customAttributes);

    return defaultAttributes;
  }

  protected abstract Map<String, Object> defaultAttributes();
}
