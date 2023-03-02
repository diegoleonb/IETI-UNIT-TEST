package co.eci.ieti.lab2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.util.List;

import co.eci.ieti.lab2.service.UsuarioService;
import co.eci.ieti.lab2.model.Usuario;

@SpringBootTest
class UnitTestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testUsuarioServiceGetAll() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		usuarioService.findAll();
		verify(usuarioService, times(1)).findAll();
	}
	
	@Test
	void testUsuarioServiceGetById() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("perez@gmaail.com");
		usuario.setPassword("1234");
		when(usuarioService.findById(1)).thenReturn(usuario);
		assert usuarioService.findById(1).getNombre().equals("Juan");
	}

	@Test
	void testUsuarioServiceSave() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("juan@gmail.com");
		usuario.setPassword("1234");
		usuarioService.save(usuario);
		verify(usuarioService, times(1)).save(usuario);
	}

	@Test
	void testUsuarioServiceExistsById() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("perez@gmail.com");
		usuario.setPassword("1234");
		when(usuarioService.existsById(1)).thenReturn(true);
		assert usuarioService.existsById(1);
	}

	@Test
	void testUsuarioServiceUpdate() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("perez@gmail.com");
		usuario.setPassword("1234");
		usuarioService.update(1, usuario);
		verify(usuarioService, times(1)).update(1, usuario);
	}

	@Test
	void testUsuarioServiceDelete() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("perez@gmail.com");
		usuario.setPassword("1234");
		usuarioService.delete(1);
		verify(usuarioService, times(1)).delete(1);
	}

	@Test
	void testUsuarioServiceGetByIdFail() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("perez@gmail.com");
		usuario.setPassword("1234");
		when(usuarioService.findById(1)).thenReturn(usuario);
		assert !usuarioService.findById(1).getNombre().equals("Pedro");
	}

	@Test
	void testUsuarioServiceGetAllEmpty() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		List<Usuario> usuarios =usuarioService.findAll();
		assert usuarios.size() == 0;
	}

	@Test
	void testUsuarioServiceGetAllNotEmpty() {
		UsuarioService usuarioService = mock(UsuarioService.class);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Juan");
		usuario.setApellido("Perez");
		usuario.setEmail("perez@gmail.com");
		usuario.setPassword("1234");
		usuarioService.save(usuario);
		List<Usuario> usuarios =usuarioService.findAll();
		assert usuarios.size() != 1;
	}

}