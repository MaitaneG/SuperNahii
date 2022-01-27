using SuperNaaahi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public interface IInkestaService
    {
       Task InkestaBete(Inkesta i);
       Task InkestaAldatu(Inkesta i);
       Task <Inkesta> KonprobatuKorreoa(string korreoa);

    }
}
