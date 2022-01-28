using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models
{
    /// <summary>
    /// Inkesta egiteko modeloa
    /// [Key]:Primary key
    /// [ScaffoldColumn(false)]: Datu baseko eremua ez hartzeko
    /// [Required(ErrorMessage ="Zure korreoa derrigorrez sartu behar duzu.")]:Korreoa derrigorrezkoa izateko
    /// [Required(ErrorMessage = "Balorazioa derrigorrez sartu behar duzu.")]: Balorazioa derrigorrezkoa izateko
    /// </summary>
    public class Inkesta
    {
        
        [Key]
        [Required(ErrorMessage ="Zure korreoa derrigorrez sartu behar duzu.")] // Korreoa derrigorrezkoa izateko
        [RegularExpression("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", ErrorMessage = "Korreoaren formatua gaizki dago.")] // Korreoaren formatua konprobatzeko
        public string Korreoa { get; set; }
        [Required(ErrorMessage = "Balorazioa derrigorrez sartu behar duzu.")] // Balorazioa derrigorrezkoa izateko
        public int Balorazioa { get; set; }
        public string Hobetzeko { get; set; }
        public bool Gomendatu { get; set; }
    }
}
