

import com.exemple.forohub.DTO.DatosRegistroCurso;
import com.exemple.forohub.enumerador.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
public class curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Categoría principal del curso")
    private Categoria categoriaPrincipal;

    @Schema(description = "Subcategoría del curso, debe coincidir con una de las subcategorías de la categoría principal",
            allowableValues = {
                    "(Java", "Python", "JavaScript", "C#", "C++", "Ruby", "Swift", "Kotlin", "TypeScript", "Go", "PHP", "HTML/CSS)",
                    "(Spring Framework", "Django", "React.js", "Angular", "Vue.js", "Express.js", "Flutter", ".NET Core", "Ruby on Rails", "Laravel)",
                    "(Frontend Development", "Backend Development", "Desarrollo Full Stack", "Arquitectura Web", "Seguridad Web", "Experiencia de Usuario (UX)", "Diseño Web)",
                    "(iOS Development", "Android Development", "Desarrollo Cross-Platform", "Diseño de Interfaz de Usuario Móvil (UI)", "Desarrollo de Juegos Móviles)",
                    "(Integración Continua / Entrega Continua (CI/CD)", "Administración de Sistemas", "Contenedores (Docker, Kubernetes)", "Gestión de Configuración (Ansible, Chef, Puppet)", "Monitoreo y Registro)",
                    "(SQL", "NoSQL", "Bases de Datos Relacionales", "Bases de Datos No Relacionales", "Modelado de Datos", "Big Data)",
                    "(Machine Learning", "Deep Learning", "Procesamiento del Lenguaje Natural (NLP)", "Visión por Computadora", "Análisis de Datos", "Minería de Datos)",
                    "(Ciberseguridad", "Ethical Hacking", "Auditoría de Seguridad", "Protección de Datos", "Criptografía)",
                    "(Desarrollo de Videojuegos", "Desarrollo de Software Empresarial", "Metodologías de Desarrollo Ágil", "Tutoriales y Recursos de Aprendizaje", "Carrera y Desarrollo Profesional)"
            },
            example = "Java")
    private String subcategoria;

    private Boolean status;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private List<Topico> topicos;

    public curso(DatosRegistroCurso registroCurso) {
        this.nombre = registroCurso.nombre();
        this.categoriaPrincipal = registroCurso.categoriaPrincipal();
        this.subcategoria = registroCurso.subcategoria();
        this.status = true;
    }

    public curso(Long id, String nombre, Categoria categoriaPrincipal, String subcategoria, Boolean status, List<Topico> topicos) {
        this.id = id;
        this.nombre = nombre;
        this.categoriaPrincipal = categoriaPrincipal;
        this.subcategoria = subcategoria;
        this.status = status;
        this.topicos = topicos;
    }

    public curso() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Categoria getCategoriaPrincipal() {
        return this.categoriaPrincipal;
    }

    public String getSubcategoria() {
        return this.subcategoria;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public List<Topico> getTopicos() {
        return this.topicos;
    }

    @JsonIgnore
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoriaPrincipal(Categoria categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonIgnore
    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof curso)) return false;
        final curso other = (curso) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof curso;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}
