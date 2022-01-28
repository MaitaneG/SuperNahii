using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Reportea

{
    /// <summary>
    ///Puntuazioa onenak bistaratzeko modeloa
    /// </summary>
    
    public class PuntuazioaHallOfFame
    {
        public int Id { get; set; }
        public string Jokalari { get; set; }
        public int Puntuazioa { get; set; }
        public DateTime Data { get; set; }
    }
}
