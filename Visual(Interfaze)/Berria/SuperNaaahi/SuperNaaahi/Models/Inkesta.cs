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
        public string Pertsona { get; set; }
        public int Balorazioa { get; set; }
        public string Hobetzeko { get; set; }
        public bool Gomendatu { get; set; }
    }
}
