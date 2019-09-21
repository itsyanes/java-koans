package objects;

import io.fries.koans.Koan;

import static io.fries.koans.KoanAssert.__;
import static io.fries.koans.KoanAssert.assertThat;

@SuppressWarnings("all")
class ObjectsKoans {

    @Koan
    void new_object_instances_can_be_created_directly() {
        assertThat(new Object() instanceof Object).isEqualTo(__);
    }

    @Koan
    void all_classes_inherit_from_object() {
        class Animal {
        }

        assertThat(new Animal() instanceof Animal).isEqualTo(__);
        assertThat(new Animal() instanceof Object).isEqualTo(__);
    }

    @Koan
    void all_classes_have_a_default_to_string_method() {
        Object object = new Object();

        // Default toString() method uses the class full name as prefix and its memory address as suffix.
        assertThat(object.toString().startsWith("java.lang.Object@")).isEqualTo(__);
    }

    @Koan
    void to_string_can_be_overridden() {
        Object object = new Object() {
            @Override
            public String toString() {
                return "Custom toString";
            }
        };

        assertThat(object.toString()).isEqualTo(__);
    }

    @Koan
    void to_string_is_implicitly_called_for_string_concatenation() {
        final String string = "ha";

        Object object = new Object() {
            @Override
            public String toString() {
                return string;
            }
        };

        assertThat(string + object).isEqualTo(__);
    }

    @Koan
    void to_string_can_be_used_with_null_references_when_invoked_implicitly() {
        String string = "string";

        assertThat(string + null).isEqualTo(__);
    }

    @Koan
    void all_classes_have_a_default_hash_code_method() {
        Object object = new Object();

        assertThat(object.hashCode() > 0).isEqualTo(__);
    }

    @Koan
    void hash_code_can_be_overridden() {
        int fixedHashCode = 42;

        Object object = new Object() {
            @Override
            public int hashCode() {
                return fixedHashCode;
            }
        };

        assertThat(object.hashCode()).isEqualTo(__);
    }

    @Koan
    void system_hash_code_will_always_return_the_default_hash_code_value() {
        int fixedHashCode = 42;

        Object object = new Object() {
            @Override
            public int hashCode() {
                return fixedHashCode;
            }
        };

        assertThat(object.hashCode()).isEqualTo(__);
        assertThat(object.hashCode() == System.identityHashCode(object)).isEqualTo(__);
    }

    @Koan
    void system_hash_code_of_a_null_reference_is_always_zero() {
        Object object = null;

        assertThat(System.identityHashCode(object)).isEqualTo(__);
    }

    @Koan
    void an_object_state_is_composed_of_its_attributes() {
        class User {
            int age = 18;
        }

        User user = new User();

        assertThat(user.age).isEqualTo(__);
    }

    @Koan
    void an_object_state_should_be_initialized_through_its_constructor() {
        class User {
            int age;

            User(int age) {
                this.age = age;
            }
        }

        User user = new User(20);

        assertThat(user.age).isEqualTo(__);
    }

    @Koan
    void an_object_behavior_is_defined_by_its_methods_and_should_hide_the_object_state_to_the_outside_world() {
        class User {
            private int age;

            User(int age) {
                this.age = age;
            }

            boolean isAdult() {
                return age >= 18;
            }
        }

        User child = new User(7);
        User adult = new User(33);

        assertThat(child.isAdult()).isEqualTo(__);
        assertThat(adult.isAdult()).isEqualTo(__);
    }

    @Koan
    void an_object_should_always_implement_custom_behaviors_for_to_string_equals_and_hash_code() {
        class User {
            private int age;

            User(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "User{" +
                        "age=" + age +
                        '}';
            }

            @Override
            public boolean equals(final Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                final User user = (User) o;
                return age == user.age;
            }

            @Override
            public int hashCode() {
                return age;
            }
        }

        User child = new User(7);
        User adult = new User(33);

        assertThat(child.toString()).isEqualTo(__);
        assertThat(adult.toString()).isEqualTo(__);

        assertThat(child.equals(adult)).isEqualTo(__);
        assertThat(child.equals(child)).isEqualTo(__);

        assertThat(child.hashCode()).isEqualTo(__);
        assertThat(adult.hashCode()).isEqualTo(__);
    }
}
