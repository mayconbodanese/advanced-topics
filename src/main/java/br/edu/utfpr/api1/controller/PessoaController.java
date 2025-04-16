// package br.edu.utfpr.api1.controller;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import br.edu.utfpr.api1.model.Pessoa;
// import br.edu.utfpr.api1.repository.PessoaRepository;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// @RestController
// @RequestMapping(value = "/pessoa", produces = "application/json")
// public class PessoaController {
//     @Autowired
//     private PessoaRepository pessoaRepository;

//     @GetMapping("/1")    
//     public Pessoa getOne() {
//         var p = new Pessoa(1, "Pedro", "p@uol.com");
//         return p;
//     }
//     @PostMapping("/")    
//     public Pessoa create(@RequestBody Pessoa p) {
//         return pessoaRepository.save(p);
//     }
// }