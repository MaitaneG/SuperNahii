using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public interface IPuntuazioaService
    {

        Task<List<Puntuazioa>> GetPuntuazioak();
    }
}
