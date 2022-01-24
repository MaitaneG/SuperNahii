using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Models
{
    /**
     * Foroa egiteko modeloa
     */
    public class Foroa
    {
        public int Id{ get; set; }
        public string Korreoa { get; set; }
        public string Komentarioa { get; set; }
        public DateTime data { get; set; }
    }
}
