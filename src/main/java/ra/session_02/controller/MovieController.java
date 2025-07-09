package ra.session_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.session_02.entity.Movie;
import ra.session_02.service.MovieService;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "movie_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie_add";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Movie> optionalMovie = movieService.findById(id);
        if (optionalMovie.isPresent()) {
            model.addAttribute("movie", optionalMovie.get());
            return "movie_edit";
        } else {
            return "redirect:/movies";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie) {
        movie.setId(id);
        movieService.update(movie);
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }
}