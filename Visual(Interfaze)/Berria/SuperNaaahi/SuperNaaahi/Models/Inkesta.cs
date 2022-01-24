using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models
{
    public class Inkesta
    {
        [Key]
        [Required(ErrorMessage ="Zure korreoa derrigorrez sartu behar duzu.")]
        [RegularExpression("^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", ErrorMessage = "E-mail is not valid")]
        public string Korreoa { get; set; }
        [Required(ErrorMessage = "Balorazioa derrigorrez sartu behar duzu.")]
        public int Balorazioa { get; set; }
        public string Hobetzeko { get; set; }
        public bool Gomendatu { get; set; }
    }
}
