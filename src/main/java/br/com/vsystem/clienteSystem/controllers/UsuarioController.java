package br.com.vsystem.clienteSystem.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.vsystem.clienteSystem.doman.Usuario;
import br.com.vsystem.clienteSystem.repositorios.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired		
	private UsuarioRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value="/usuario")
	public ModelAndView inicio() {
		ModelAndView andView = new ModelAndView("cadastro/usuario");
		andView.addObject("usuarioobj", new Usuario());
		return andView;
	}	
	
	@RequestMapping(method = RequestMethod.POST, value="**/salvarUsuario")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			ModelAndView andView = new ModelAndView("cadastro/usuario");
			 Iterable<Usuario> usuariosIt = repository.findAll();
			    andView.addObject("usuarios", usuariosIt);
			    andView.addObject("usuarioobj", usuario);
			    
			    List<String> msg= new ArrayList<String>();
			    for (ObjectError objectErro : bindingResult.getAllErrors()) {
			    	msg.add(objectErro.getDefaultMessage());//vem das anotações notEmpit do doman
			    }
			   
			    andView.addObject("msg",msg);
			    return andView;
		}
		
	    repository.save(usuario);
	    
	    ModelAndView andView = new ModelAndView("cadastro/usuario");
	    Iterable<Usuario> usuariosIt = repository.findAll();
	    andView.addObject("usuarios", usuariosIt);
	    andView.addObject("usuarioobj", new Usuario());
	    return andView;
	}
		
	@RequestMapping(method = RequestMethod.GET, value="/listarUsuario")
	public ModelAndView usuarios(){
		ModelAndView andView = new ModelAndView("cadastro/usuario");
		Iterable<Usuario> usuarioIt = repository.findAll();
		andView.addObject("usuarios", usuarioIt);
		andView.addObject("usuarioobj",new Usuario());
	   return andView;
	}
	
	@PostMapping("**/pesquisar")
	public ModelAndView pesquisar(@RequestParam("nom_usuario") String nom_usuario) {
		
		ModelAndView andView = new ModelAndView("cadastro/usuario");
		andView.addObject("usuarios", repository.findByNomUsuario(nom_usuario));
		andView.addObject("usuarioobj",new Usuario());
		return andView;
	}  
	
	@RequestMapping(method = RequestMethod.GET, value="/editarUsuario/{cod_usuario}")
	public ModelAndView editar(@PathVariable("cod_usuario") long cod_usuario){
	    Optional<Usuario> usuario = repository.findById(cod_usuario);
		ModelAndView andView = new ModelAndView("cadastro/usuario");
		andView.addObject("usuarioobj", usuario.get());
	   return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/excluirUsuario/{cod_usuario}")
	public ModelAndView excluir(@PathVariable("cod_usuario") long cod_usuario){
	   repository.deleteById(cod_usuario);
		ModelAndView andView = new ModelAndView("cadastro/usuario");
		andView.addObject("usuarios", repository.findAll());
		andView.addObject("usuarioobj", new Usuario());
	   return andView;
	}
	
	/*void ContactController(UsuarioRepository usuarioRepository) {
	       this.repository = usuarioRepository;
	   }
	
	

	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/usuario")
	public String showPages(Model model, @RequestParam(defaultValue="0") int page){		
	 model.addAttribute("date", repository.
			 findAll(PageRequest.of(0, 4, Direction.valueOf("cadastro/usuario"), "nomeUsuario")));			 
		return "cadastro/usuario";
	}*/
	
	/*	@PutMapping(value="/{id}")
	public ResponseEntity<Usuario> update(@PathVariable("id") Long id,
	                                      @RequestBody Usuario usuario) {
	   return repository.findById(id)
	           .map(record -> {
	               record.setNom_usuario(usuario.getNom_usuario());	              
	               Usuario updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/delete")
	public String delete(Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
	
  @GetMapping("cadastro/usuario")
	public Page<Usuario> usuarios(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	@GetMapping("/")
	public String showPages(Model model, @RequestParam(defaultValue="0") int page){		
	 model.addAttribute("date", repo.
			 findAll(PageRequest.of(0, 4, Direction.valueOf("Usuario"), "nomeUsuario")));			 
		return "index";
	}	
	
	@GetMapping("/")
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	@PostMapping("/save")
	public String save(Usuario obj) {
		repo.save(obj);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(Integer id) {
		repo.deleteById(id);
		return "redirect:/";
	}
	
	@GetMapping("/findOne")	
	@ResponseBody
	public Usuario findOne(Integer id) {
		return  repo.findById(id).orElse(null);
	}*/
}
